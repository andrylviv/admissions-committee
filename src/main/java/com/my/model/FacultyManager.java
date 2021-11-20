package com.my.model;

import com.my.db.DBManager;
import com.my.db.FacultyDAO;
import com.my.db.entity.Faculty;

import java.sql.Connection;
import java.sql.SQLException;

public class FacultyManager {
    public static void updateFaculty(int id, int stFunPlaces, int totPlaces, String name, String languageId){
        Connection conn  = DBManager.getConnection();
        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setStFundedPlaces(stFunPlaces);
        faculty.setTotPlaces(totPlaces);
        faculty.setName(name);
        faculty.setLangName(languageId);
        new FacultyDAO().updateFaculty(conn,faculty);
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addFaculty(int stFunPlaces, int totPlaces, String name, String languageId){
        Connection conn  = DBManager.getConnection();
        Faculty faculty = new Faculty();
        faculty.setStFundedPlaces(stFunPlaces);
        faculty.setTotPlaces(totPlaces);
        faculty.setName(name);
        faculty.setLangName(languageId);
        new FacultyDAO().addFaculty(conn,faculty);
        new FacultyDAO().addFacultyLocal(conn,faculty);
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addFacultyLocal(int id, String name, String languageId){
        Connection conn  = DBManager.getConnection();
        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setLangName(languageId);
        new FacultyDAO().addFacultyLocal(conn,faculty);
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
