package com.my.db;

import com.my.db.entity.Faculty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class FacultyDAOTest {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "root";
    private static final String PASS = "1991";


    @BeforeClass
    public static void beforeTest() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS faculty (\n" +
                    "  id INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                    "  st_funded_places INT NULL DEFAULT NULL,\n" +
                    "  tot_places INT NULL DEFAULT NULL,\n" +
                    "  eie_uk_lang INT NULL DEFAULT NULL,\n" +
                    "  eie_math INT NULL DEFAULT NULL,\n" +
                    "  eie_physics INT NULL DEFAULT NULL," +
                    "PRIMARY KEY (id));";

            statement.executeUpdate(sql);
        }
    }

    @AfterClass
    public static void afterClass() throws SQLException {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "DROP TABLE  faculty";
            statement.executeUpdate(sql);
        }
    }

    @After
    public void tearDown() throws SQLException {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "DELETE FROM  faculty";
            statement.executeUpdate(sql);
        }
    }

    @Test
    public void getFacultyByIdTest(){
        Faculty faculty = new Faculty();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)){
            PreparedStatement stat = connection.prepareStatement("INSERT INTO faculty(st_funded_places,tot_places,eie_uk_lang,eie_math,eie_physics) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            faculty.setStFundedPlaces(5);
            faculty.setTotPlaces(6);
            faculty.setIsEieUkLang(1);
            faculty.setIsEieMath(1);
            faculty.setIsEiePhysics(1);
            stat.setInt(1,faculty.getStFundedPlaces());
            stat.setInt(2,faculty.getTotPlaces());
            stat.setInt(3,faculty.getIsEieUkLang());
            stat.setInt(4,faculty.getIsEieMath());
            stat.setInt(5,faculty.getIsEiePhysics());
            stat.executeUpdate();
            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    faculty.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Faculty facultyGet = null;
        try {
            facultyGet = new FacultyDAO().getFacultyById(DriverManager.getConnection(DB_URL, USER, PASS),faculty.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(((Integer)faculty.getStFundedPlaces()).equals(facultyGet.getStFundedPlaces())
                &&((Integer)faculty.getTotPlaces()).equals(facultyGet.getTotPlaces())
                &&((Integer)faculty.getIsEieUkLang()).equals(facultyGet.getIsEieUkLang())
                &&((Integer)faculty.getIsEieMath()).equals(facultyGet.getIsEieMath())
                &&((Integer)faculty.getIsEiePhysics()).equals(facultyGet.getIsEiePhysics()));
    }

    @Test
    public void addFacultyTest(){
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stat = connection.prepareStatement("SELECT * FROM faculty WHERE id=?")) {

            Faculty faculty = new Faculty();
            faculty.setStFundedPlaces(5);
            faculty.setTotPlaces(6);
            faculty.setIsEieUkLang(1);
            faculty.setIsEieMath(1);
            faculty.setIsEiePhysics(1);

            new FacultyDAO().addFaculty(connection, faculty);
            Faculty facultyGet = new Faculty();

                stat.setInt(1,faculty.getId());
                try(ResultSet resultSet = stat.executeQuery()) {
                    while (resultSet.next()) {
                        facultyGet.setId(resultSet.getInt(1));
                        facultyGet.setStFundedPlaces(resultSet.getInt(2));
                        facultyGet.setTotPlaces(resultSet.getInt(3));
                        facultyGet.setIsEieUkLang(resultSet.getInt(4));
                        facultyGet.setIsEieMath(resultSet.getInt(5));
                        facultyGet.setIsEiePhysics(resultSet.getInt(6));
                    }
                }
            assertTrue(((Integer)faculty.getStFundedPlaces()).equals(facultyGet.getStFundedPlaces())
                    &&((Integer)faculty.getTotPlaces()).equals(facultyGet.getTotPlaces())
                    &&((Integer)faculty.getIsEieUkLang()).equals(facultyGet.getIsEieUkLang())
                    &&((Integer)faculty.getIsEieMath()).equals(facultyGet.getIsEieMath())
                    &&((Integer)faculty.getIsEiePhysics()).equals(facultyGet.getIsEiePhysics()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}