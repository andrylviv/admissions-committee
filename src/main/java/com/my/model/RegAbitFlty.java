package com.my.model;

import com.my.db.DBManager;
import com.my.db.UserFacultyDAO;
import com.my.db.entity.UserFaculty;

import java.sql.Connection;

public class RegAbitFlty {


    public static void regUserFlty(int us, int flty){
        Connection conn  = DBManager.getConnection();
        UserFaculty userFaculty = new UserFaculty();
        userFaculty.setUserId(us);
        userFaculty.setFacultyId(flty);
        new UserFacultyDAO().insertUserFaculty(conn,userFaculty);
    }


}
