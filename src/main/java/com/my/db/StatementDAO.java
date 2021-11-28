package com.my.db;

import com.my.db.entity.Statement;
import com.my.db.entity.UserFaculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatementDAO {
    public static final String USER_ON_FACULTY_EXIST = "SELECT * FROM statement WHERE user_id=?";
    public static final String INSERT_USER_FACULTY_STATEMENT = "INSERT INTO statement(user_id,faculty_id) VALUES (?,?)";
    public static final String INSERT_SFP_FLAG = "UPDATE statement SET st_fon_pl = ? WHERE user_id = ?";
    public static final String INSERT_NSFP_FLAG = "UPDATE statement SET non_st_fon_pl = ? WHERE user_id = ?";
    public static final String GET_APPLICANT_FROM_STATEMENT = "SELECT * FROM statement WHERE faculty_id=?";
    public static final String REMOVE_APPLICANT= "DELETE FROM statement WHERE user_id =?";
    public static final String RESET_FLAG = "UPDATE statement SET non_st_fon_pl = 0, st_fon_pl = 0";

    public boolean  ifUserExist(Connection conn, UserFaculty uf){
        int uId = 0;
        try(PreparedStatement stat = conn.prepareStatement(USER_ON_FACULTY_EXIST)) {

            stat.setInt(1,uf.getUserId());
            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    uId = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uId>0;
    }

    public void  insertUserFacultyStatement(Connection conn, UserFaculty userFaculty){
        try (PreparedStatement stat = conn.prepareStatement(INSERT_USER_FACULTY_STATEMENT)){

            stat.setInt(1,userFaculty.getUserId());
            stat.setInt(2,userFaculty.getFacultyId());
            stat.executeUpdate();
        } catch (SQLException e) {
            //add logger
        }
    }

    public List<Statement> getApplicant(Connection conn, int facultyId){

        List<Statement> applicantList = new ArrayList<>();
        try(
                PreparedStatement stat = conn.prepareStatement(GET_APPLICANT_FROM_STATEMENT)) {
            stat.setInt(1,facultyId);
            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    Statement statement = new Statement();
                    statement.setUserId(resultSet.getInt(1));
                    statement.setFacultyId(resultSet.getInt(2));
                    statement.setStFonPl(resultSet.getInt(3));
                    statement.setNonStFonPl(resultSet.getInt(4));
                    applicantList.add(statement);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applicantList;
    }

    public void  removeApplicant(Connection conn,int id){
        try{
            PreparedStatement stat = conn.prepareStatement(REMOVE_APPLICANT);
            stat.setInt(1,id);

            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  setStFonPl(Connection conn,int id, int flag) {
        try {
            PreparedStatement prSt = conn.prepareStatement(INSERT_SFP_FLAG);
            prSt.setInt(1, flag);
            prSt.setInt(2, id);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  setNonStFonPl(Connection conn,int id, int flag) {
        try {
            PreparedStatement prSt = conn.prepareStatement(INSERT_NSFP_FLAG);
            prSt.setInt(1, flag);
            prSt.setInt(2, id);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  resetFlag(Connection conn) {
        try {
            java.sql.Statement stat=conn.createStatement();
            stat.executeUpdate(RESET_FLAG);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
