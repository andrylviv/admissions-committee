package com.my.db.entity;

public class Faculty extends Entity{

    private static final long serialVersionUID = 5456277830808334232L;
    int id;
    String name;
    int stFundedPlaces;
    int totPlaces;
    String langName;
    int isEieMath;
    int isEieUkLang;
    int isEiePhysics;

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

    public Integer getId() {
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

    public int getIsEieMath() {
        return isEieMath;
    }

    public void setIsEieMath(int isEieMath) {
        this.isEieMath = isEieMath;
    }

    public int getIsEieUkLang() {
        return isEieUkLang;
    }

    public void setIsEieUkLang(int isEieUkLang) {
        this.isEieUkLang = isEieUkLang;
    }

    public int getIsEiePhysics() {
        return isEiePhysics;
    }

    public void setIsEiePhysics(int isEiePhysics) {
        this.isEiePhysics = isEiePhysics;
    }
}
