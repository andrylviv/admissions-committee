package com.my.db.entity;

public class Statement {
    int userId;
    int facultyId;
    int stFonPl;
    int nonStFonPl;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getStFonPl() {
        return stFonPl;
    }

    public void setStFonPl(int stFonPl) {
        this.stFonPl = stFonPl;
    }

    public int getNonStFonPl() {
        return nonStFonPl;
    }

    public void setNonStFonPl(int nonStFonPl) {
        this.nonStFonPl = nonStFonPl;
    }
}
