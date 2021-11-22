package com.my.model;

import com.my.db.DBManager;
import com.my.db.StatementDAO;
import com.my.db.UserFacultyDAO;
import com.my.db.entity.UserFaculty;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StatementManager {
    public static void addApplicantToStatement(int facultyId){
        final Connection conn = DBManager.getConnection();
        List<UserFaculty> ufl = new UserFacultyDAO().getApplicant(conn, facultyId);
        StatementDAO statementDAO = new StatementDAO();
        for (UserFaculty uf:ufl) {
            if (!(statementDAO.ifUserExist(conn, uf))){
                statementDAO.insertUserFacultyStatement(conn, uf);
            }
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
