package com.example.nahiduddinahammed.minidoctorproject;

public class Ambulence {

    private String name;
    private String addrees;
    private String number;


    public Ambulence(String name, String addrees, String number, int doc) {
        this.name = name;
        this.addrees = addrees;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getAddrees() {
        return addrees;
    }

    public String getNumber() {
        return number;
    }
}
