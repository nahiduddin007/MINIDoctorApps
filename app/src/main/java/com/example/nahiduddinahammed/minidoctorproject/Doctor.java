package com.example.nahiduddinahammed.minidoctorproject;

public class Doctor {

    private int id;
    private String name;
    private String consultant;
    private String phone;
    private String hospital;
    private int image;

    public Doctor(int id, String name, String consultant, String phone, String hospital, int image) {
        this.id = id;
        this.name = name;
        this.consultant = consultant;
        this.phone = phone;
        this.hospital = hospital;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getConsultant() {
        return consultant;
    }

    public String getPhone() {
        return phone;
    }

    public String getHospital() {
        return hospital;
    }

    public int getImage() {
        return image;
    }
}
