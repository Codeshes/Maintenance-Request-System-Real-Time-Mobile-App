package com.example.maintenancerequestsystemreal_timemobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginPageActivity extends AppCompatActivity {

    EditText login_userName, login_userPassword;
    Button loginButton;
    TextView signUpRedirectPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        login_userName = findViewById(R.id.username);
        login_userPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.btnLogin);
        signUpRedirectPage = findViewById(R.id.signUpRedirectPage);


        loginButton.setOnClickListener(v -> {
            if (!validateUsername() | !validatePassword()) {

            } else {
                checkUser();
            }
        });

        signUpRedirectPage.setOnClickListener(v -> {
            Intent intent = new Intent(LoginPageActivity.this, SignUpPageActivity.class);
            startActivity(intent);
        });

    }

    public Boolean validateUsername() {
        String val = login_userName.getText().toString();
        if (val.isEmpty()) {
            login_userName.setError("Username cannot be empty");
            return false;
        } else {
            login_userName.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = login_userPassword.getText().toString();
        if (val.isEmpty()) {
            login_userPassword.setError("Password cannot be empty");
            return false;
        } else {
            login_userPassword.setError(null);
            return true;
        }
    }

    public void checkUser() {
        String userName = login_userName.getText().toString();
        String password = login_userPassword.getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userName);


        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    login_userName.setError(null);
                    String passwordFromDb = snapshot.child(userName).child("password").getValue(String.class);

                    if (!Objects.equals(passwordFromDb, password)) {
                        login_userName.setError(null);
                        Intent intent = new Intent (LoginPageActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        login_userPassword.setError("Invalid Credentials");
                        login_userPassword.requestFocus();
                    }
                } else {
                    login_userName.setError("User does not exist");
                    login_userName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}