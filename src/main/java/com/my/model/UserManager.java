package com.my.model;

import com.my.db.DBManager;
import com.my.db.UserDAO;
import com.my.db.UserInfoDAO;
import com.my.db.entity.User;
import com.my.db.entity.UserInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserManager {
    public static List<UserInfo> getUsersInfo(){
        final Connection conn = DBManager.getConnection();
        List<UserInfo> ul = new UserInfoDAO().getUsersInf(conn);
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ul;
    }

    public static UserInfo getUserIn(int id){
        final Connection conn = DBManager.getConnection();
        UserInfo ui = new UserInfoDAO().getUserInfo(conn, id);
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ui;
    }

    public static User getUser(int id){
        final Connection conn = DBManager.getConnection();
        User u = new UserDAO().getUserById(conn, id);
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    public static void stBlockFlag(int id, int blFlag){
        final Connection conn = DBManager.getConnection();
        new UserDAO().setBlockFlag(conn, id, blFlag);
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
