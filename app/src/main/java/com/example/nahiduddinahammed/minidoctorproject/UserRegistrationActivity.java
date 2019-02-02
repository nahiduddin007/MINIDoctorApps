package com.example.nahiduddinahammed.minidoctorproject;

import android.app.ProgressDialog;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class UserRegistrationActivity extends AppCompatActivity {

    Button button;
    private EditText name;
    private EditText email;
    private EditText password;

    private FirebaseAuth firebaseAuth;

    private DatabaseReference mDatabase;

    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);


        firebaseAuth=FirebaseAuth.getInstance();

        mDatabase= FirebaseDatabase.getInstance().getReference().child("Users");

        mProgress=new ProgressDialog(this);




        name=findViewById(R.id.TVname);
        email=findViewById(R.id.TVemail);
        password=findViewById(R.id.TVpassword);





        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                startRegister();


            }
        });
    }


    private void startRegister()
    {
         String nam = name.getText().toString();
         String eml = email.getText().toString();
         String pass = password.getText().toString();


        if (TextUtils.isEmpty(nam)){
            Toast.makeText(UserRegistrationActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(eml)){
            Toast.makeText(UserRegistrationActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(pass)){
            Toast.makeText(UserRegistrationActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }else if (pass.length()<6){
            Toast.makeText(UserRegistrationActivity.this,"Password must be greater then 6 digit",Toast.LENGTH_SHORT).show();
            return;
        }

        mProgress.setMessage("Creating User please wait...");
        mProgress.setCanceledOnTouchOutside(false);
        mProgress.show();

             firebaseAuth.createUserWithEmailAndPassword(eml,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if (task.isSuccessful()) {

                         sendEmailVerification();
                         mProgress.dismiss();
                         OnAuth(task.getResult().getUser());
                         firebaseAuth.signOut();


                     } else {

                         Toast.makeText(UserRegistrationActivity.this,"error on creating user",Toast.LENGTH_SHORT).show();

                     }

                 }
             });
         }

    //Email verification code using FirebaseUser object and using isSucccessful()function.
    private void sendEmailVerification() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(UserRegistrationActivity.this,"Check your Email for verification",Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                    }
                }
            });
        }
    }

    private void OnAuth(FirebaseUser user) {
        createAnewUser(user.getUid());
    }

    private void createAnewUser(String uid) {
        User user = BuildNewuser();
        mDatabase.child(uid).setValue(user);
    }


    private User BuildNewuser(){
        return new User(
                getDisplayName(),
                getUserEmail(),
                new Date().getTime()
        );
    }

    public String getDisplayName() {
        return String.valueOf(name);
    }

    public String getUserEmail() {
        return String.valueOf(email);
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
