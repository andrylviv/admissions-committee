package com.my.model;

import com.my.db.*;
import com.my.db.entity.Faculty;
import com.my.db.entity.User;
import com.my.db.entity.UserFaculty;
import com.my.db.entity.UserInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public static boolean regUserOnFaculty(int userId, int facultyId, int eieUkLang,int eieMath, int eiePhysics){
        final Connection conn = DBManager.getConnection();
        Faculty faculty = new FacultyDAO().getFacultyById(conn, facultyId);
        UserInfoDAO infoDAO = new UserInfoDAO();
        if ((faculty.getIsEieUkLang()>0) && (eieUkLang>0) && (eieUkLang<12))
            infoDAO.setEieUkLang(conn,userId,eieUkLang);
        if ((faculty.getIsEieMath()>0) && (eieMath>0) && (eieMath<12))
            infoDAO.setEieMath(conn,userId,eieMath);
        if ((faculty.getIsEiePhysics()>0) && (eiePhysics>0) && (eiePhysics<12))
            infoDAO.setEiePhysics(conn,userId,eiePhysics);
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return true;}

    public static List<UserInfo> getApplicantFaculty(int fId){
        final Connection conn = DBManager.getConnection();
        List<UserFaculty> userList = new UserFacultyDAO().getApplicant(conn,fId);
        List<UserInfo> userInfoList = new ArrayList<>();
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        for (UserFaculty uf:userList) {
            userInfoList.add(userInfoDAO.getUserInfo(conn,uf.getUserId()));
        }try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfoList;
    }
}
