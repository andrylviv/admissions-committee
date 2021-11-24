package com.my.model;

import com.my.db.DBManager;
import com.my.db.UserFacultyDAO;
import com.my.db.entity.UserFaculty;

import java.sql.Connection;
import java.sql.SQLException;

public class RegAbitFlty {


    public static void regUserFlty(int us, int flty){
        try(Connection conn  = DBManager.getConnection()){
            UserFaculty userFaculty = new UserFaculty();
            userFaculty.setUserId(us);
            userFaculty.setFacultyId(flty);
            new UserFacultyDAO().insertUserFaculty(conn,userFaculty);
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public static void unRegUserFlty(int us, int flty){
        try(Connection conn  = DBManager.getConnection()){
            UserFaculty userFaculty = new UserFaculty();
            userFaculty.setUserId(us);
            userFaculty.setFacultyId(flty);
            new UserFacultyDAO().removeUserFaculty(conn,userFaculty);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
