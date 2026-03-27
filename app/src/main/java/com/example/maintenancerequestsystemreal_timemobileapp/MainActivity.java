package com.example.maintenancerequestsystemreal_timemobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Button submitRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        submitRequest = findViewById(R.id.btnSubmit);


        submitRequest.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RequestActivity.class);
            startActivity(intent);
        });


        bottomNav.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();
            
            if (itemId == R.id.home) {
                return true;
            } else if (itemId == R.id.requests) {
                // TODO: Show requests here via recycler View
                return true;
            } else if (itemId == R.id.profile) {
                // profile here
                // TODO: Implement profile
                return true;
            }
            return false;
        });

    }
}