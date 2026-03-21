package com.example.maintenancerequestsystemreal_timemobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpPageActivity extends AppCompatActivity {

    EditText signupName, signupEmail, signupUsername, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up_page);

        signupName = findViewById(R.id.signupName);
        signupEmail = findViewById(R.id.signupEmail);
        signupUsername = findViewById(R.id.signupUsername);
        signupPassword = findViewById(R.id.signupPassword);
        signupButton = findViewById(R.id.btnSignUp);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(v -> {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");


            String name = signupName.getText().toString().trim();
            String email = signupEmail.getText().toString().trim();
            String username = signupUsername.getText().toString().trim();
            String password = signupPassword.getText().toString().trim();

            if (name.isEmpty()) {
                signupName.setError("Name required.");
                signupName.requestFocus();
            } else if (email.isEmpty()) {
                signupEmail.setError("Email required.");
                signupEmail.requestFocus();
            } else if (username.isEmpty()) {
                signupUsername.setError("Username required.");
                signupUsername.requestFocus();
            } else if (password.isEmpty()) {
                signupPassword.setError("Password required.");
                signupPassword.requestFocus();
            } else {
                HelperClassLoginSignup helperClass = new HelperClassLoginSignup(name, email, username, password);
                reference.child(name).setValue(helperClass);
                Toast.makeText(this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpPageActivity.this, LoginPageActivity.class);
                startActivity(intent);
            }
        });

        loginRedirectText.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpPageActivity.this, LoginPageActivity.class);
            startActivity(intent);
        });
    }
}