package com.my.model;

import javax.validation.constraints.*;

public class Account {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String partonymic;
    private String city;
    private String region;
    private String school;
    private int ukLang;
    private int ukLiter;
    private int eng;
    private int algebra;
    private int informatics;
    private int geometry;
    private int ukHistory;
    private int phTraining;
    private int physics;

    @NotEmpty
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty
    @Pattern(regexp = "\\b[A-ZА-ЯЇІЄ][a-zа-яїіє]+\\b")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty
    @Pattern(regexp = "\\b[A-ZА-ЯЇІЄ][a-zа-яїіє]+\\b")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotEmpty
    @Pattern(regexp = "\\b[A-ZА-ЯЇІЄ][a-zа-яїіє]+\\b")
    public String getPartonymic() {
        return partonymic;
    }

    public void setPartonymic(String partonymic) {
        this.partonymic = partonymic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @NotNull
    @Min(0)
    @Max(12)
    public int getUkLang() {
        return ukLang;
    }

    public void setUkLang(int ukLang) {
        this.ukLang = ukLang;
    }

    @NotNull
    @Min(0)
    @Max(12)
    public int getUkLiter() {
        return ukLiter;
    }

    public void setUkLiter(int ukLiter) {
        this.ukLiter = ukLiter;
    }

    @NotNull
    @Min(0)
    @Max(12)
    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    @NotNull
    @Min(0)
    @Max(12)
    public int getAlgebra() {
        return algebra;
    }

    public void setAlgebra(int algebra) {
        this.algebra = algebra;
    }

    @NotNull
    @Min(0)
    @Max(12)
    public int getInformatics() {
        return informatics;
    }

    public void setInformatics(int informatics) {
        this.informatics = informatics;
    }

    @NotNull
    @Min(0)
    @Max(12)
    public int getGeometry() {
        return geometry;
    }

    public void setGeometry(int geometry) {
        this.geometry = geometry;
    }

    @NotNull
    @Min(0)
    @Max(12)
    public int getUkHistory() {
        return ukHistory;
    }

    public void setUkHistory(int ukHistory) {
        this.ukHistory = ukHistory;
    }

    @NotNull
    @Min(0)
    @Max(12)
    public int getPhTraining() {
        return phTraining;
    }

    public void setPhTraining(int phTraining) {
        this.phTraining = phTraining;
    }

    @NotNull
    @Min(0)
    @Max(12)
    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }
}
