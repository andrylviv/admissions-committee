package com.my.db;

import com.my.db.entity.Faculty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;


public class FacultyDAO {
    public static final String GET_FACULTY = "SELECT * FROM faculty";
    public static final String GET_LANGUAGE_ID = "SELECT id FROM language where language=?";
    public static final String GET_FACULTY_NAME = "SELECT faculty_name FROM faculty_translate where faculty_id=? and language_id=?";
    public static final String UPDATE_FACULTY = "UPDATE faculty SET st_funded_places = ?, tot_places= ?, eie_uk_lang = ?, eie_math = ?, eie_physics = ? WHERE id = ?";
    public static final String UPDATE_FACULTY_TRANSLATE = "UPDATE faculty_translate SET faculty_name = ? WHERE faculty_id = ? and language_id =?";
    public static final String INSERT_FACULTY = "INSERT INTO faculty(st_funded_places,tot_places,eie_uk_lang,eie_math,eie_physics) VALUES (?,?,?,?,?)";
    public static final String INSERT_FACULTY_TRANSLATION = "INSERT INTO faculty_translate(faculty_id, faculty_name,language_id) VALUES (?,?,?)";
    public static final String GET_FACULTY_BY_ID = "SELECT * FROM faculty WHERE id=?";
    public static final String REMOVE_FACULTY= "DELETE FROM faculty WHERE id =?";

    public Faculty  getFacultyById(Connection conn,int id){
        Faculty faculty = new Faculty();
        try(//Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(GET_FACULTY_BY_ID)) {
            stat.setInt(1,id);
            try(ResultSet resultSet = stat.executeQuery()) {
                while (resultSet.next()) {
                    faculty.setId(resultSet.getInt(1));
                    faculty.setStFundedPlaces(resultSet.getInt(2));
                    faculty.setTotPlaces(resultSet.getInt(3));
                    faculty.setIsEieUkLang(resultSet.getInt(4));
                    faculty.setIsEieMath(resultSet.getInt(5));
                    faculty.setIsEiePhysics(resultSet.getInt(6));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculty;
    }

    public int getLangId(Connection conn, String lang){
        int langId = 0;
        try {
            PreparedStatement prSt1 = conn.prepareStatement(GET_LANGUAGE_ID);
            prSt1.setString(1, lang);

            ResultSet resSet = prSt1.executeQuery();
                if (resSet.next()) {
                    langId = resSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return langId;
        }

    public List<Faculty> findAllFaculty(Connection conn,String lang){
        List<Faculty> teamList = new ArrayList<>();
        try(Statement stat=conn.createStatement();
            ResultSet resultSet=stat.executeQuery(GET_FACULTY)) {

            PreparedStatement prSt1 = conn.prepareStatement(GET_FACULTY_NAME);  //refactor

            while (resultSet.next()){
                Faculty faculty = new Faculty();
                int id = resultSet.getInt(1);
                faculty.setId(id);
                prSt1.setInt(1,id);
                prSt1.setInt(2,getLangId(conn, lang));
                ResultSet rsi = prSt1.executeQuery();
                if(rsi.next()) {
                    faculty.setName(rsi.getString(1));
                }
                faculty.setStFundedPlaces(resultSet.getInt(2));
                faculty.setTotPlaces(resultSet.getInt(3));
                faculty.setIsEieUkLang(resultSet.getInt(4));
                faculty.setIsEieMath(resultSet.getInt(5));
                faculty.setIsEiePhysics(resultSet.getInt(6));
                if (!nonNull(faculty.getName()))
                    faculty.setName("add locale name");
                teamList.add(faculty);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamList;
    }

    public void updateFaculty(Connection conn,Faculty faculty) {

        try {
             PreparedStatement prSt = conn.prepareStatement(UPDATE_FACULTY) ;
                prSt.setInt(1,faculty.getStFundedPlaces());
                prSt.setInt(2,faculty.getTotPlaces());
                prSt.setInt(3,faculty.getIsEieUkLang());
                prSt.setInt(4,faculty.getIsEieMath());
                prSt.setInt(5,faculty.getIsEiePhysics());
                prSt.setInt(6,faculty.getId());
                prSt.executeUpdate();

             prSt = conn.prepareStatement(UPDATE_FACULTY_TRANSLATE);
                prSt.setString(1,faculty.getName());
                prSt.setInt(2,faculty.getId());
                prSt.setInt(3,getLangId(conn, faculty.getLangName()));
                prSt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addFaculty(Connection conn,Faculty faculty) {
        try {
            PreparedStatement stat = conn.prepareStatement(INSERT_FACULTY, Statement.RETURN_GENERATED_KEYS);

            stat.setInt(1,faculty.getStFundedPlaces());
            stat.setInt(2,faculty.getTotPlaces());
            stat.setInt(3,faculty.getIsEieUkLang());
            stat.setInt(4,faculty.getIsEieMath());
            stat.setInt(5,faculty.getIsEiePhysics());
            stat.executeUpdate();
            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    faculty.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFacultyLocal(Connection conn,Faculty faculty) {
        try {
            PreparedStatement stat = conn.prepareStatement(INSERT_FACULTY_TRANSLATION);
            stat.setInt(1,faculty.getId());
            stat.setString(2,faculty.getName());
            stat.setInt(3,getLangId(conn, faculty.getLangName()));
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  removeFaculty(Connection conn,int id){
        try{
            PreparedStatement stat = conn.prepareStatement(REMOVE_FACULTY);
            stat.setInt(1,id);

            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
