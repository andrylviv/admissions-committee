package com.my.db;

import com.my.db.entity.User;
import com.my.db.entity.UserFaculty;

import java.sql.*;

import static com.my.db.DBManager.getConnection;

public class UserFacultyDAO {
    public static final String INSERT_USER_FACULTY = "INSERT INTO user_faculty(user_id,faculty_id) VALUES (?,?)";

    public void  insertUserFaculty(Connection conn,UserFaculty userFaculty){
        try (//Connection conn  = getConnection();
             PreparedStatement stat = conn.prepareStatement(INSERT_USER_FACULTY)){

            stat.setInt(1,userFaculty.getUserId());
            stat.setInt(2,userFaculty.getFacultyId());
            stat.executeUpdate();
           /* try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }*/
        } catch (SQLException e) {
            //add logger
        }
    }
}
