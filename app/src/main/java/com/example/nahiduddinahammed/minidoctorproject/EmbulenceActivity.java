package com.example.nahiduddinahammed.minidoctorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmbulenceActivity extends AppCompatActivity {



    RecyclerView recyclerView;
    AmbulenceAdapter adapter;

    List<Ambulence> ambulenceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embulence);



        ambulenceList = new ArrayList<>();

        recyclerView =  findViewById(R.id.ambulenceRV);
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        ambulenceList.add(
                new Ambulence(
                        "BIRDEM",
                        "Shabag",
                        "9661551-60",
                        R.drawable.doc));
        ambulenceList.add(
                new Ambulence(
                        "CMH",
                        "Dhaka",
                        "9871469",
                        R.drawable.doc));
        ambulenceList.add(
                new Ambulence(
                        "Dhaka City Corporation",
                        "Mirpur Control Room",
                        "9004734",
                        R.drawable.doc));
        ambulenceList.add(
                new Ambulence(
                        "Dhaka City Corporation ",
                        "Nagar Bhaban Control Room",
                        "9556014",
                        R.drawable.doc));
        ambulenceList.add(
                new Ambulence(
                        "ICDDRB",
                        "Mohakhali",
                        "8811751-60",
                        R.drawable.doc));
        ambulenceList.add(
                new Ambulence(
                        "Lab-aid Cardiac hospital",
                        "banana-Baridhara-uttoraRayer",
                        "01715120229",
                        R.drawable.doc));
        ambulenceList.add(
                new Ambulence(
                        "Lab-aid Cardiac hospital",
                        "Dhanmondi-Azimpur-Shahbagh",
                        "01713025911",
                        R.drawable.doc));
        ambulenceList.add(
                new Ambulence(
                        "Lab-aid Cardiac hospital",
                        "Bazaar-lalmatia-mohamamdpur",
                        "01715120228",
                        R.drawable.doc));
        ambulenceList.add(
                new Ambulence(
                        "Salimullah Medical College",
                        "Dhaka",
                        "7319002-6",
                        R.drawable.doc));
        ambulenceList.add(
                new Ambulence(
                        "National Heart Institute",
                        "Dhaka",
                        "9122560-72",
                        R.drawable.doc));

        adapter = new AmbulenceAdapter(this,ambulenceList);
        recyclerView.setAdapter(adapter);






    }
}
