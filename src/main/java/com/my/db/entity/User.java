package com.my.db.entity;

public class User {
    private int id;
    private String email;
    private String password;
    private int isAdmin;
    //private int userInfoId;

    public User() {
    }


    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
   /* public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }
*/
}
