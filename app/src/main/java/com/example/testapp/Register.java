package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    TextView mname, mpass, mtextbelow, memail;
    Button submit;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mname = findViewById(R.id.username);
        mpass = findViewById(R.id.pass);
        memail = findViewById(R.id.email);
        mtextbelow = findViewById(R.id.bottemtext);
        submit = findViewById(R.id.regButton);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.proBar);
        // User Already Register........


        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();

        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = memail.getText().toString().trim();
                String password = mpass.getText().toString().trim();

                if (TextUtils.isEmpty(emailText)) {

                    memail.setError("Email is Required");
                    return;


                }
                if (TextUtils.isEmpty(password)) {
                    mpass.setError("Email is Required");
                    return;

                }

                if (password.length() < 6) {

                    mpass.setError("password must be bigger 6 char");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Register the user in firebase

                fAuth.createUserWithEmailAndPassword(emailText, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }


                });


            }
        });

        mtextbelow.setOnClickListener(new View.OnClickListener (){
            @Override

            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), Login.class));

            }

        });


    }
}