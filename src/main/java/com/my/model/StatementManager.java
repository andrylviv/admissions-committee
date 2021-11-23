package com.my.model;

import com.my.db.*;
import com.my.db.entity.Faculty;
import com.my.db.entity.Statement;
import com.my.db.entity.UserFaculty;
import com.my.db.entity.UserInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StatementManager {
    public static void addApplicantToStatement(int facultyId){
        final Connection conn = DBManager.getConnection();
        List<UserFaculty> ufl = new UserFacultyDAO().getApplicant(conn, facultyId);
        StatementDAO statementDAO = new StatementDAO();
        for (UserFaculty uf:ufl) {
            if (!(statementDAO.ifUserExist(conn, uf))){
                statementDAO.insertUserFacultyStatement(conn, uf);
            }
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void finaliseStatement(){
        final Connection conn = DBManager.getConnection();
        FacultyDAO fd = new FacultyDAO();
        StatementDAO sd = new StatementDAO();
        UserInfoDAO uid = new UserInfoDAO();
        List<Faculty> facultyList = fd.findAllFaculty(conn,"en");
        for (Faculty faculty:facultyList) {
            List<Statement> statementList = sd.getApplicant(conn,faculty.getId());
            List<Applicant> applicantList = new ArrayList<>();
            for (Statement st:statementList) {
                int applId = st.getUserId();
                UserInfo userInfo = uid.getUserInfo(conn,applId);
                Applicant applicant = new Applicant();
                applicant.setApplicantId(userInfo.getUserId());
                applicant.setMark(getAverageMark(userInfo, faculty));
                applicantList.add(applicant);
            }
            finalise(conn, applicantList, faculty);

        }
    }

    public static int getAverageMark(UserInfo userInfo,Faculty faculty){

        int avrCertMark = (userInfo.getUkLang() + userInfo.getUkLiter() + userInfo.getEng() + userInfo.getAlgebra() + userInfo.getInformatics()+
                userInfo.getGeometry() + userInfo.getUkHistory() + userInfo.getPhTraining() + userInfo.getPhysics())/9;
        int eieMark = 0;
        int divisor = 0;
        if (faculty.getIsEieUkLang()==1){
            eieMark += userInfo.getEieUkLang();
            ++divisor;
        }
        if (faculty.getIsEieMath()==1){
            eieMark += userInfo.getEieMath();
            ++divisor;
        }
        if (faculty.getIsEiePhysics()==1){
            eieMark += userInfo.getEiePhysics();
            ++divisor;
        }
        int avrEieMark = eieMark / divisor;


    return  (avrCertMark + avrEieMark) / 2;
    }

    public static void finalise(Connection connection, List<Applicant> applicantList, Faculty faculty){

        applicantList.sort(Comparator.comparing(Applicant::getMark));
        if (applicantList.size() >= faculty.getTotPlaces()) {
            List<Applicant> applicantListStFoun = applicantList.subList(0, faculty.getStFundedPlaces());
            List<Applicant> applicantListNonStFoun = applicantList.subList(faculty.getStFundedPlaces() + 1, faculty.getTotPlaces());

            setStFonPlFlag(connection, applicantListStFoun);
            setNonStFonPlFlag(connection, applicantListNonStFoun);
         /*   StatementDAO statementDAO = new StatementDAO();

            for (Applicant applicant : applicantListStFoun) {
                statementDAO.setStFonPl(connection, applicant.getApplicantId(), 1);
            }
            for (Applicant applicant : applicantListNonStFoun) {
                statementDAO.setNonStFonPl(connection, applicant.getApplicantId(), 1);
            }*/
        }
        if (applicantList.size() <= faculty.getTotPlaces()) {
            if (applicantList.size() >= faculty.getStFundedPlaces()){
                List<Applicant> applicantListStFoun = applicantList.subList(0, faculty.getStFundedPlaces());
                setStFonPlFlag(connection, applicantListStFoun);
            }
            if (applicantList.size() <= faculty.getStFundedPlaces()){
                List<Applicant> applicantListStFoun = applicantList;
                setStFonPlFlag(connection, applicantListStFoun);
            }
            if (applicantList.size() >= faculty.getStFundedPlaces()){
                List<Applicant> applicantListNonStFoun = applicantList.subList(faculty.getStFundedPlaces() + 1, applicantList.size());
                setNonStFonPlFlag(connection, applicantListNonStFoun);
            }
        }
    }
    public static void setStFonPlFlag(Connection connection, List<Applicant> applicantListStFoun){
        StatementDAO statementDAO = new StatementDAO();
        for (Applicant applicant : applicantListStFoun) {
            statementDAO.setStFonPl(connection, applicant.getApplicantId(), 1);
        }
    }
    public static void setNonStFonPlFlag(Connection connection, List<Applicant> applicantListNonStFoun){
        StatementDAO statementDAO = new StatementDAO();
        for (Applicant applicant : applicantListNonStFoun) {
            statementDAO.setNonStFonPl(connection, applicant.getApplicantId(), 1);
        }
    }
}
