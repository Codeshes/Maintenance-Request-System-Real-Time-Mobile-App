package com.example.maintenancerequestsystemreal_timemobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView totalRequestText, pendingRequestText, completedRequestText;
    Button submitRequest;
    String loggedInUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loggedInUsername = getIntent().getStringExtra("username");

        totalRequestText = findViewById(R.id.tvTotalCount);
        pendingRequestText = findViewById(R.id.tvPendingCount);
        completedRequestText = findViewById(R.id.tvCompletedCount);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        submitRequest = findViewById(R.id.btnSubmit);

        submitRequest.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RequestActivity.class);
            intent.putExtra("username", loggedInUsername);
            startActivity(intent);
        });

        Query userRequestsQuery = FirebaseDatabase.getInstance()
                .getReference("requests")
                .orderByChild("username")
                .equalTo(loggedInUsername);

        userRequestsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int totalCount = (int) snapshot.getChildrenCount();
                int pendingCount = 0;
                int completedCount = 0;

                for (DataSnapshot data : snapshot.getChildren()) {
                    HelperClassRequest request = data.getValue(HelperClassRequest.class);

                    if (request != null && request.getStatus() != null) {
                        String status = request.getStatus();

                        if (status.equalsIgnoreCase("Pending")) {
                            pendingCount++;
                        } else if (status.equalsIgnoreCase("Completed")) {
                            completedCount++;
                        }
                    }
                }

                totalRequestText.setText(String.valueOf(totalCount));
                pendingRequestText.setText(String.valueOf(pendingCount));
                completedRequestText.setText(String.valueOf(completedCount));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this,
                                "ERROR" + error.getMessage(),
                                Toast.LENGTH_SHORT)
                        .show();
            }
        });

        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                return true;
            } else if (itemId == R.id.requests) {
                // TODO: Show requests here via recycler View
                return true;
            } else if (itemId == R.id.profile) {
                // TODO: Implement profile
                return true;
            }
            return false;
        });
    }
}
