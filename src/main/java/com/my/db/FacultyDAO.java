package com.my.db;

import com.my.db.entity.Faculty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.my.db.DBManager.getConnection;

public class FacultyDAO {
    public List<Faculty> findAllFaculty(Connection conn,String lang){
        List<Faculty> teamList = new ArrayList<>();
        try(//Connection conn = getConnection();
            Statement stat=conn.createStatement();
            ResultSet resultSet=stat.executeQuery("SELECT * FROM faculty");
            PreparedStatement prSt = conn.prepareStatement("SELECT id FROM language where language=?")) {
            prSt.setString(1,lang);
            int langId = 0;
            try(ResultSet resSet = prSt.executeQuery()) {
                if(resSet.next()) {
                    langId = resSet.getInt(1);
                }
            }

            PreparedStatement prSt1 = conn.prepareStatement("SELECT faculty_name FROM faculty_translate where faculty_id=? and language_id=?");

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
