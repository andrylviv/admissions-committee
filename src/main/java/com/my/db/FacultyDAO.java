package com.my.db;

import com.my.db.entity.Faculty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.my.db.DBManager.getConnection;

public class FacultyDAO {
    public static final String GET_FACULTY = "SELECT * FROM faculty";
    public static final String GET_LANGUAGE_ID = "SELECT id FROM language where language=?";
    public static final String GET_FACULTY_NAME = "SELECT faculty_name FROM faculty_translate where faculty_id=? and language_id=?";

    public List<Faculty> findAllFaculty(Connection conn,String lang){
        List<Faculty> teamList = new ArrayList<>();
        try(//Connection conn = getConnection();
            Statement stat=conn.createStatement();
            ResultSet resultSet=stat.executeQuery(GET_FACULTY);
            PreparedStatement prSt = conn.prepareStatement(GET_LANGUAGE_ID)) {
            prSt.setString(1,lang);
            int langId = 0;
            try(ResultSet resSet = prSt.executeQuery()) {
                if(resSet.next()) {
                    langId = resSet.getInt(1);
                }
            }

            PreparedStatement prSt1 = conn.prepareStatement(GET_FACULTY_NAME);

            while (resultSet.next()){
                Faculty faculty = new Faculty();
                int id = resultSet.getInt(1);
                faculty.setId(id);
                //faculty.setName(resultSet.getString(1));
                prSt1.setInt(1,id);
                prSt1.setInt(2,langId);
                ResultSet rsi = prSt1.executeQuery();
                if(rsi.next()) {
                    faculty.setName(rsi.getString(1));
                }
                faculty.setStFundedPlaces(resultSet.getInt(2));
                faculty.setTotPlaces(resultSet.getInt(3));
                teamList.add(faculty);
            }

        } catch (SQLException e) {
            //add logger
            e.printStackTrace();
        }
        return teamList;
    }
}
