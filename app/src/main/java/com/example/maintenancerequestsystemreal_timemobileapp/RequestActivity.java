package com.example.maintenancerequestsystemreal_timemobileapp;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RequestActivity extends AppCompatActivity {

    Toolbar tb;
    EditText etRequestTitle, etLocation, etDescription;
    Button btnSubmitRequest, btnSelectImage;
    DatabaseReference dataBaseReference;

    Uri imageUri;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    HelperClassRequest helperClassRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tb = findViewById(R.id.toolbar);
        tb.setNavigationOnClickListener(v -> finish());

        etRequestTitle = findViewById(R.id.etRequestTitle);
        etLocation = findViewById(R.id.etLocation);
        etDescription = findViewById(R.id.etDescription);
        btnSubmitRequest = findViewById(R.id.btnSubmitRequest);
        btnSelectImage = findViewById(R.id.btnUploadImage);

        






    }
}