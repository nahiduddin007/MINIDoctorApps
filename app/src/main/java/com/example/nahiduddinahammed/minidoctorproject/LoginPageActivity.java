package com.example.nahiduddinahammed.minidoctorproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPageActivity extends AppCompatActivity {

    private TextView TVemail;
    private TextView TVpassword;
    private TextView clickTV;
    private Button loginbtn;

    private Context context=this;


    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    FirebaseUser mUser;

    ProgressDialog dialog;

    public static final String userEmail="";

    public static final String TAG="LOGIN";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TVemail=findViewById(R.id.email);
        TVpassword=findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbutton);
        clickTV = findViewById(R.id.clickableTV);


        dialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (mUser != null) {
                    Intent intent = new Intent(LoginPageActivity.this, MainPageActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Log.d(TAG,"AuthStateChanged:Logout");
                }

            }
        };

        clickTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginPageActivity.this,UserRegistrationActivity.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        //removeAuthSateListner is used  in onStart function just for checking purposes,it helps in logging you out.
        mAuth.removeAuthStateListener(mAuthListner);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListner != null) {
            mAuth.removeAuthStateListener(mAuthListner);
        }

    }

    @Override
    public void onBackPressed() {
        LoginPageActivity.super.finish();
    }

    private void checkLogin()
    {
         String email = TVemail.getText().toString().trim();
         final String pass = TVpassword.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(LoginPageActivity.this, "Enter the correct Email", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(LoginPageActivity.this, "Enter the correct password", Toast.LENGTH_SHORT).show();
            return;
        }
       dialog.setMessage("Loging in please wait...");
       dialog.setIndeterminate(true);
        dialog.show();

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    dialog.dismiss();

                    Toast.makeText(LoginPageActivity.this, "Login not successfull", Toast.LENGTH_SHORT).show();

                } else {
                    dialog.dismiss();

                    checkIfEmailVerified();

                }
            }
        });

    }



    private void checkIfEmailVerified(){
        FirebaseUser users=FirebaseAuth.getInstance().getCurrentUser();
        boolean emailVerified=users.isEmailVerified();
        if(!emailVerified){
            Toast.makeText(this,"Verify the Email Id",Toast.LENGTH_SHORT).show();
            mAuth.signOut();
            finish();
        }
        else {
            TVemail.getText().length();

            TVpassword.getText().length();
            Intent intent = new Intent(LoginPageActivity.this, MainPageActivity.class);

            // Sending Email to Dashboard Activity using intent.
            intent.putExtra(userEmail,emailVerified);

            startActivity(intent);

        }
    }


}
