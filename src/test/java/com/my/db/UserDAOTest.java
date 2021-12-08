package com.my.db;

import com.my.db.entity.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;


import static org.junit.Assert.*;

public class UserDAOTest {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String URL_CONNECTION = "jdbc:h2:~/test;user=root;password=1991;";
    private static final String USER = "root";
    private static final String PASS = "1991";


    @BeforeClass
    public static void beforeTest() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS user (\n" +
                    "  id INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                    "  email VARCHAR(45) NULL DEFAULT NULL UNIQUE,\n" +
                    "  is_admin INT NULL DEFAULT NULL,\n" +
                    "  password VARCHAR(200) NULL DEFAULT NULL,\n" +
                    "  is_blocked TINYINT NOT NULL," +
                    "PRIMARY KEY (id));";

            statement.executeUpdate(sql);
        }
    }

    @AfterClass
    public static void afterClass() throws SQLException {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "DROP TABLE  user";
            statement.executeUpdate(sql);
        }
    }

    @After
    public void tearDown() throws SQLException {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "DELETE FROM  user";
            statement.executeUpdate(sql);
        }
    }

    @Test
    public void testInsertUser() throws SQLException {
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)){
            User user = new User();
            user.setEmail("exem@mail.com");
            user.setIsAdmin(0);
            user.setPassword("1111");
            user.setIsBlocked(0);
            new UserDAO().insertUser(connection, user);
            User us = new User();
            PreparedStatement stat = connection.prepareStatement("SELECT * FROM user WHERE email=?");
            stat.setString(1, user.getEmail());
            try (ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    us.setEmail(resultSet.getString(2));
                    us.setIsAdmin(resultSet.getInt(3));
                    us.setPassword(resultSet.getString(4));
                    us.setIsBlocked(resultSet.getInt(5));
                }
            }
            assertTrue(user.getEmail().equals(us.getEmail()) && ((Integer) user.getIsAdmin()).equals(us.getIsAdmin())
                    &&((Integer)user.getIsAdmin()).equals(us.getIsAdmin())//&&user.getPassword().equals(us.getPassword())
                    &&((Integer)user.getIsBlocked()).equals(us.getIsBlocked()));
        }
    }

    @Test
    public void testGetUser() throws SQLException {
        User user = new User();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stat = connection.prepareStatement("INSERT INTO user(email,is_admin,password,is_blocked) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)){
                user.setEmail("exem@mail.com");
                user.setIsAdmin(0);
                user.setPassword("1111");
                user.setIsBlocked(0);
            stat.setString(1, user.getEmail());
            stat.setString(2, String.valueOf(user.getIsAdmin()));
            stat.setString(3, user.getPassword());
            stat.setInt(4, 0);
            stat.executeUpdate();
            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
            User us = new UserDAO().getUser(connection,user.getEmail(),user.getPassword());
            assertTrue(user.getEmail().equals(us.getEmail()) && ((Integer) user.getIsAdmin()).equals(us.getIsAdmin())
                    &&((Integer)user.getIsAdmin()).equals(us.getIsAdmin())//&&user.getPassword().equals(us.getPassword())
                    &&((Integer)user.getIsBlocked()).equals(us.getIsBlocked()));
        }
    }

    @Test
    public void testGetUserById() throws SQLException {
        User user = new User();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stat = connection.prepareStatement("INSERT INTO user(email,is_admin,password,is_blocked) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            user.setEmail("exem@mail.com");
            user.setIsAdmin(0);
            user.setPassword("1111");
            user.setIsBlocked(0);
            stat.setString(1, user.getEmail());
            stat.setString(2, String.valueOf(user.getIsAdmin()));
            stat.setString(3, user.getPassword());
            stat.setInt(4, 0);
            stat.executeUpdate();
            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
            User us = new UserDAO().getUserById(connection,user.getId());
            assertTrue(user.getEmail().equals(us.getEmail()) && ((Integer) user.getIsAdmin()).equals(us.getIsAdmin())
                    &&((Integer)user.getIsAdmin()).equals(us.getIsAdmin())//&&user.getPassword().equals(us.getPassword())
                    &&((Integer)user.getIsBlocked()).equals(us.getIsBlocked()));
        }
    }

    @Test
    public void testIfUserExist() throws SQLException {
        User user = new User();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stat = connection.prepareStatement("INSERT INTO user(email,is_admin,password,is_blocked) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            user.setEmail("exem@mail.com");
            user.setIsAdmin(0);
            user.setPassword("1111");
            user.setIsBlocked(0);
            stat.setString(1, user.getEmail());
            stat.setString(2, String.valueOf(user.getIsAdmin()));
            stat.setString(3, user.getPassword());
            stat.setInt(4, 0);
            stat.executeUpdate();
            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
            boolean ifUserExist = new UserDAO().ifUserExist(connection,user.getEmail(),user.getPassword());
            assertTrue(ifUserExist);
        }
    }

    @Test
    public void testSetBlockFlag() throws SQLException {
        User user = new User();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stat = connection.prepareStatement("INSERT INTO user(email,is_admin,password,is_blocked) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            user.setEmail("exem@mail.com");
            user.setIsAdmin(0);
            user.setPassword("1111");
            user.setIsBlocked(0);
            stat.setString(1, user.getEmail());
            stat.setString(2, String.valueOf(user.getIsAdmin()));
            stat.setString(3, user.getPassword());
            stat.setInt(4, 0);
            stat.executeUpdate();
            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
            new UserDAO().setBlockFlag(connection,user.getId(),1);
            int isBlocked = 0;
                PreparedStatement stat1 = connection.prepareStatement("SELECT is_blocked FROM user WHERE id=?");
                stat1.setInt(1, user.getId());
                try (ResultSet resultSet = stat1.executeQuery()) {
                    while (resultSet.next()) {
                        isBlocked = resultSet.getInt(1);
                    }
                }
            assertTrue(isBlocked==1);
        }
    }
}