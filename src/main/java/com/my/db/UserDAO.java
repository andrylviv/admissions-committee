package com.my.db;

import com.my.db.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.my.db.DBManager.getConnection;

public class UserDAO {
    public void  insertUser(User user){
        try (Connection conn  = getConnection();
             PreparedStatement stat = conn.prepareStatement("INSERT INTO user(email,is_admin,password) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)){

            stat.setString(1,user.getEmail());
            stat.setString(2,String.valueOf(user.getIsAdmin()));
            stat.setString(3,user.getPassword());
            stat.executeUpdate();
            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            //add logger
        }
    }

    public List<User> findAllUsers(){
        List<User> userList = new ArrayList<>();
        try(Connection conn = getConnection();
            Statement stat=conn.createStatement();ResultSet resultSet=stat.executeQuery("SELECT * FROM user WHERE is_admin=0")) {

            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setIsAdmin(resultSet.getInt(3));

                userList.add(user);
            }


        } catch (SQLException e) {
            //add logger
        }
        return userList;
    }
    public User  getUser(Connection conn,String em,String pass){
        User us = new User();
        try(//Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement("SELECT * FROM user WHERE email=?and password=?")) {

            stat.setString(1,em);
            stat.setString(2,pass);
            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    us.setId(resultSet.getInt(1));
                    us.setEmail(resultSet.getString(2));

                    us.setIsAdmin(resultSet.getInt(3));
                    us.setPassword(resultSet.getString(4));
                }
            }
        } catch (SQLException e) {
            //add logger
        }
        return us;
    }
    public boolean  ifUserExist(Connection conn,String em,String pass){
        User us = new User();
        try(//Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement("SELECT * FROM user WHERE email=?and password=?")) {

            stat.setString(1,em);
            stat.setString(2,pass);
            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                   // us.setId(resultSet.getInt(1));
                    us.setEmail(resultSet.getString(2));

                   // us.setIsAdmin(resultSet.getInt(3));
                    us.setPassword(resultSet.getString(4));
                }
            }
        } catch (SQLException e) {
            //add logger
        }

        return us.getEmail()!=null&&us.getPassword()!=null;
    }
}
