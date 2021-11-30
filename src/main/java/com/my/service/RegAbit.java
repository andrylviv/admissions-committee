package com.my.service;

import com.my.db.DBManager;
import com.my.db.UserDAO;
import com.my.db.UserInfoDAO;
import com.my.db.entity.User;
import com.my.db.entity.UserInfo;
import com.my.model.Account;

import java.sql.Connection;

public class RegAbit {


    public static void regAbit(Account account){
        Connection conn  = DBManager.getConnection();
        User us = new User();
        us.setEmail(account.getEmail());
        us.setPassword(account.getPassword());
        us.setIsAdmin(0);
        UserInfo usI = new UserInfo();
        usI.setFirstName(account.getFirstName());
        usI.setLastName(account.getLastName());
        usI.setPartonymic(account.getPartonymic());
        usI.setCity(account.getCity());
        usI.setRegion(account.getRegion());
        usI.setSchool(account.getSchool());
        usI.setUkLang(account.getUkLang());
        usI.setUkLiter(account.getUkLiter());
        usI.setEng(account.getEng());
        usI.setAlgebra(account.getAlgebra());
        usI.setInformatics(account.getInformatics());
        usI.setGeometry(account.getGeometry());
        usI.setUkHistory(account.getUkHistory());
        usI.setPhTraining(account.getPhTraining());
        usI.setPhysics(account.getPhysics());
       /* usI.setEieUkLang(eieUkLang);
        usI.setEieMath(eieMath);*/

        new UserDAO().insertUser(conn,us);
        new UserInfoDAO().insertUserInf(conn,us,usI);
    }


}
