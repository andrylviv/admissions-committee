package com.my.db;

import com.my.db.entity.UserFaculty;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserFacultyDAO {
    public static final String INSERT_USER_FACULTY = "INSERT INTO user_faculty(user_id,faculty_id) VALUES (?,?)";
    public static final String GET_APPLICANT_FROM_FACULTY = "SELECT * FROM user_faculty WHERE faculty_id=?";

    public void  insertUserFaculty(Connection conn,UserFaculty userFaculty){
        try (PreparedStatement stat = conn.prepareStatement(INSERT_USER_FACULTY)){

            stat.setInt(1,userFaculty.getUserId());
            stat.setInt(2,userFaculty.getFacultyId());
            stat.executeUpdate();

        } catch (SQLException e) {
            //add logger
        }
    }

    public List<UserFaculty> getApplicant(Connection conn, int facultyId){

        List<UserFaculty> userList = new ArrayList<>();
        try(
            PreparedStatement stat = conn.prepareStatement(GET_APPLICANT_FROM_FACULTY)) {
            stat.setInt(1,facultyId);
            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    UserFaculty userFaculty = new UserFaculty();
                    userFaculty.setUserId(resultSet.getInt(1));
                    userFaculty.setFacultyId(resultSet.getInt(2));
                    userList.add(userFaculty);
                }
            }
        } catch (SQLException e) {
            //add logger
        }
        return userList;
    }
}
