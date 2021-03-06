package com.my.db;

import com.my.db.entity.User;
import com.my.service.Password;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class UserDAO {

    public static final String INSERT_USER = "INSERT INTO user(email,is_admin,password,is_blocked) VALUES (?,?,?,?)";
    public static final String GET_USER = "SELECT * FROM user WHERE email=? and password=?";
    public static final String USER_EXIST = "SELECT * FROM user WHERE email=? and password=?";
    public static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    public static final String INSERT_BLOCK_FLAG = "UPDATE user SET is_blocked = ? WHERE id = ?";

    public void  insertUser(Connection conn,User user){
        try (PreparedStatement stat = conn.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)){

            stat.setString(1,user.getEmail());
            stat.setString(2,String.valueOf(user.getIsAdmin()));
            stat.setString(3,Password.hash(user.getPassword()));
            stat.setInt(4,0);
            stat.executeUpdate();
            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public User  getUser(Connection conn,String em,String pass){
        User us = new User();
        try(PreparedStatement stat = conn.prepareStatement(GET_USER)) {

            stat.setString(1,em);
            stat.setString(2,pass);
            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    us.setId(resultSet.getInt(1));
                    us.setEmail(resultSet.getString(2));

                    us.setIsAdmin(resultSet.getInt(3));
                    us.setPassword(resultSet.getString(4));
                    us.setIsBlocked(resultSet.getInt(5));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return us;
    }

    public User  getUserById(Connection conn,int id){
        User us = new User();
        try(PreparedStatement stat = conn.prepareStatement(GET_USER_BY_ID)) {
            stat.setInt(1,id);
            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    us.setId(resultSet.getInt(1));
                    us.setEmail(resultSet.getString(2));

                    us.setIsAdmin(resultSet.getInt(3));
                    us.setPassword(resultSet.getString(4));
                    us.setIsBlocked(resultSet.getInt(5));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return us;
    }

    public boolean  ifUserExist(Connection conn,String em,String pass){
        User us = new User();
        try(PreparedStatement stat = conn.prepareStatement(USER_EXIST)) {

            stat.setString(1,em);
            stat.setString(2,pass);
            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    us.setEmail(resultSet.getString(2));
                    us.setPassword(resultSet.getString(4));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return us.getEmail()!=null&&us.getPassword()!=null;
    }
    public void  setBlockFlag(Connection conn,int id, int blFlag) {
        try {
            PreparedStatement prSt = conn.prepareStatement(INSERT_BLOCK_FLAG);
            prSt.setInt(1, blFlag);
            prSt.setInt(2, id);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
