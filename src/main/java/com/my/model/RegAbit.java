package com.my.model;

import com.my.db.DBManager;
import com.my.db.UserDAO;
import com.my.db.UserFacultyDAO;
import com.my.db.UserInfoDAO;
import com.my.db.entity.User;
import com.my.db.entity.UserInfo;

import java.sql.Connection;

public class RegAbit {


    public static void regAbit(String email, String password, String firstName, String lastName, String partonymic,
                               String city,String region, String school, int ukLang, int ukLiter, int eng, int algebra, int informatics,
                               int geometry, int ukHistory, int phTraining, int physics, int eieUkLang, int eieMath){
        Connection conn  = DBManager.getConnection();
        User us = new User();
        us.setEmail(email);
        us.setPassword(password);
        us.setIsAdmin(0);
        UserInfo usI = new UserInfo();
        usI.setFirstName(firstName);
        usI.setLastName(lastName);
        usI.setPartonymic(partonymic);
        usI.setCity(city);
        usI.setRegion(region);
        usI.setSchool(school);
        usI.setUkLang(ukLang);
        usI.setUkLiter(ukLiter);
        usI.setEng(eng);
        usI.setAlgebra(algebra);
        usI.setInformatics(informatics);
        usI.setGeometry(geometry);
        usI.setUkHistory(ukHistory);
        usI.setPhTraining(phTraining);
        usI.setPhysics(physics);
        usI.setEieUkLang(eieUkLang);
        usI.setEieMath(eieMath);

        new UserDAO().insertUser(conn,us);
        new UserInfoDAO().insertUserInf(conn,us,usI);
    }


}
