package com.my.db.entity;

public class Faculty {
    int id;
    String name;
    int stFundedPlaces;
    int totPlaces;
    String langName;

    public Faculty() {
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", stFundedPlaces=" + stFundedPlaces +
                ", totPlaces=" + totPlaces +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStFundedPlaces() {
        return stFundedPlaces;
    }

    public void setStFundedPlaces(int stFundedPlaces) {
        this.stFundedPlaces = stFundedPlaces;
    }

    public int getTotPlaces() {
        return totPlaces;
    }

    public void setTotPlaces(int totPlaces) {
        this.totPlaces = totPlaces;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }
}
