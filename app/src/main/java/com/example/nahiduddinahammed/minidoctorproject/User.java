package com.example.nahiduddinahammed.minidoctorproject;

import android.widget.EditText;

class User {
    private String Displayname;
    private String Email;


    public User(String displayname, String email, long time){
        this.Displayname=displayname;
        this.Email=email;

    }


    public String getDisplayname() {
        return Displayname;
    }

    public String getEmail() {
        return Email;
    }



}
