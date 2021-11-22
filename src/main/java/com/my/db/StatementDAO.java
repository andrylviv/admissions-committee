package com.my.db;

import com.my.db.entity.UserFaculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementDAO {
    public static final String USER_ON_FACULTY_EXIST = "SELECT * FROM statement WHERE user_id=?";
    public static final String INSERT_USER_FACULTY_STATEMENT = "INSERT INTO statement(user_id,faculty_id) VALUES (?,?)";
    public static final String INSERT_FIN_FLAG = "UPDATE statement SET is_fin = ? WHERE user_id = ?";

    public boolean  ifUserExist(Connection conn, UserFaculty uf){
        int uId = 0;
        //Statement statement = new Statement();
        try(PreparedStatement stat = conn.prepareStatement(USER_ON_FACULTY_EXIST)) {

            stat.setInt(1,uf.getUserId());
            //stat.setInt(2,uf.getFacultyId());
            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    uId = resultSet.getInt(1);
                   // statement.setUserId(resultSet.getInt(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //add logger
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

    public void  setFinFlag(Connection conn,int id, int finFlag) {
        try {
            PreparedStatement prSt = conn.prepareStatement(INSERT_FIN_FLAG);
            prSt.setInt(1, finFlag);
            prSt.setInt(2, id);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
