package com.example.nahiduddinahammed.minidoctorproject;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context=this;

    private static int SPLASH_TIME_OUT = 4000;
   // private ConstraintLayout background;

    int backButtonCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* background=findViewById(R.id.backgroundCLK);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,MainPageActivity.class));
            }
        });*/
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {

               Intent homeIntent = new Intent(MainActivity.this,MainPageActivity.class);
               startActivity(homeIntent);
               finish();
           }
       },SPLASH_TIME_OUT);



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //startActivity(new Intent(context,LoginActivity.class));
       // getSupportActionBar().hide();

    }




}
