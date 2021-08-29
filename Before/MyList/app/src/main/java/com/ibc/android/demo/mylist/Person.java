package com.ibc.android.demo.mylist;

public class Person {
    String name;
    String moblie;

    public Person(String name, String moblie) { //생성자 추가
        this.name = name;
        this.moblie = moblie;
    }

    //Generate -> getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }
}
