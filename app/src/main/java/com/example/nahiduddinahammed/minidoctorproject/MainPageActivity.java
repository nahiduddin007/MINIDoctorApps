package com.example.nahiduddinahammed.minidoctorproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainPageActivity extends AppCompatActivity {
    private Context context=this;

    int backButtonCount=0;

    private LinearLayout firstaid;
    private  LinearLayout hospital;
    private  LinearLayout bmi;
    private  LinearLayout medicine;
    private  LinearLayout doctor;
    private  LinearLayout search;
    private LinearLayout favourite;
    private LinearLayout ambulence;
    private  LinearLayout ussd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        firstaid = findViewById(R.id.grad1);
        medicine = findViewById(R.id.grad2);
        favourite = findViewById(R.id.grad3);
        hospital = findViewById(R.id.grad4);
        doctor = findViewById(R.id.grad5);
        ussd = findViewById(R.id.grad6);
        ambulence= findViewById(R.id.grad7);
        search =findViewById(R.id.grad8);
        bmi = findViewById(R.id.grad9);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //startActivity(new Intent(context,LoginActivity.class));
//        getSupportActionBar().hide();



        firstaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,FirstaidActivity.class));
            }
        });

        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MedicinePageActivity.class));

            }
        });

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,FavouriteActivity.class));
            }
        });


        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,HospitalActivity.class));
            }
        });


        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,ConsultantListView.class));
            }
        });


        ussd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,USSDActivity.class));
            }
        });


        ambulence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,EmbulenceActivity.class));
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,SearchActivity.class));
            }
        });


        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,BMIActivity.class));
            }
        });













    }

    @Override
    public void onBackPressed()
    {
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;

        }
    }


     //FOR BACK BUTTON AUTOMATIC CREATE CODE
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
