package com.example.nahiduddinahammed.minidoctorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DoctorsPageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DoctorAdapter adapter;

    List<Doctor> doctorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_page);

        doctorList = new ArrayList<>();

        recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //adding some items to our list
      doctorList.add(
                new Doctor(
                        1,
                        "Dr. Nahid Uddin Ahammed",
                        "Cardiology",
                        "01872700022",
                        "Dhaka Medical College Hospital",
                        R.drawable.doc));

      doctorList.add(
                new Doctor(
                        1,
                        "Dr Nishat",
                        "Gayney",
                        "0186265256",
                        "Cox's Bazar Medical College Hospital",
                        R.drawable.doc));

      doctorList.add(
                new Doctor(
                        1,
                        "Dr. Razin",
                        "Neurologist",
                        "01883873087",
                        "Birdam General Hospital",
                        R.drawable.doc));
        doctorList.add(
                new Doctor(
                        1,
                        "অধ্যাপক ড. ফজলুল হক",
                        "মেডিসিন বিভাগ",
                        " +৮৮০-1674058435",
                        "ঢাকা মেডিকেল কলেজ ও হাসপাতাল",
                        R.drawable.doc));
        doctorList.add(
                new Doctor(
                        1,
                        "প্রফেসর ড. শেখ Nesaruddin আহমেদ",
                        "মেডিসিন বিভাগ",
                        "3-9670210",
                        "ঢাকা মেডিকেল কলেজ হাসপাতাল",
                        R.drawable.doc));
        doctorList.add(
                new Doctor(
                        1,
                        "Dr. Mohammad Enamul Haque",
                        "Respiratory Medicine",
                        "Dhaka Medical College Hospita",
                        "+880-2- 9118219",
                        R.drawable.doc));
        doctorList.add(
                new Doctor(
                        1,
                        "Dr. Mahmudul Huque",
                        "Endocrinology",
                        "+880-2-9126625",
                        "Holy Family Red Crescent Hospital",
                        R.drawable.doc));
        doctorList.add(
                new Doctor(
                        1,
                        "Dr. Jahangir Alam",
                        "Internal Medicine",
                        " +880-2-8159457",
                        "SQUARE Hospitals Ltd, Dhaka, Bangladesh",
                        R.drawable.doc));


      adapter = new DoctorAdapter(this,doctorList);
      recyclerView.setAdapter(adapter);








    }
}
