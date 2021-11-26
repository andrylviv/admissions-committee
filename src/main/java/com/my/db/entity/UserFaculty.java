package com.my.db.entity;

public class UserFaculty extends Entity{

    private static final long serialVersionUID = 5456277830808334232L;
    int userId;
    int facultyId;

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
}
