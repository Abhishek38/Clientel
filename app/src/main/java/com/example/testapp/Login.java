package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText loginuser,loginpassword;
    Button loginbutton;
    ProgressBar probar2;
    FirebaseAuth fAuth;
    TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginuser=findViewById(R.id.loginuser);
        loginpassword=findViewById(R.id.loginpassword);
        loginbutton=findViewById(R.id.loginbutton);
        probar2=findViewById(R.id.probar2);
        loginText = findViewById(R.id.signtext);
        


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = loginuser.getText().toString().trim();
                String password = loginpassword.getText().toString().trim();

                if (TextUtils.isEmpty(emailText)) {

                    loginuser.setError("Email is Required");
                    return;


                }
                if (TextUtils.isEmpty(password)) {
                    loginpassword.setError("Email is Required");
                    return;

                }

                if (password.length() < 6) {

                    loginpassword.setError("password must be bigger 6 char");
                    return;
                }

                probar2.setVisibility(View.VISIBLE);

                //Register the user in firebase

                fAuth.createUserWithEmailAndPassword(emailText, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Login.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }


                });


            }
        });

        loginText.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), Register.class));

            }

        });
    }
}