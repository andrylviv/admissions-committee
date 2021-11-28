package com.my.service;

import com.my.db.DBManager;
import com.my.db.FacultyDAO;
import com.my.db.entity.Faculty;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class FacultyList {


    public static List<Faculty> getFacultyList(String language){
        List<Faculty> faculties = null;
        try(final Connection conn = DBManager.getConnection()) {

            faculties = new FacultyDAO().findAllFaculty(conn, language);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculties;
    }

    public static List<Faculty> sortFaculty(List<Faculty> faculty,String sortType){
        if (sortType.equals("byName")){
            //faculty.sort((a, b) -> b.getName().compareTo(a.getName()));
            faculty.sort(Comparator.comparing(Faculty::getName));
        }

        if (sortType.equals("fp")){
            faculty.sort(Comparator.comparing(Faculty::getStFundedPlaces));
        }

        if (sortType.equals("tp")){
            faculty.sort(Comparator.comparing(Faculty::getTotPlaces));
        }
        return  faculty;
    }
}
