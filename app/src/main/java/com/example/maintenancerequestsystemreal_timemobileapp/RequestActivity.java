package com.example.maintenancerequestsystemreal_timemobileapp;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Map;

public class RequestActivity extends AppCompatActivity {

    Toolbar tb;
    EditText etRequestTitle, etLocation, etDescription;
    Button btnSubmitRequest, btnSelectImage;
    DatabaseReference dataBaseReference;

    Uri imageUri;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    HelperClassRequest helperClassRequest;

    ProgressBar progressBar;

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

        progressBar = findViewById(R.id.progressBar);


        btnSubmitRequest.setOnClickListener(v -> {


            progressBar.setVisibility(View.VISIBLE);
            btnSubmitRequest.setEnabled(false);

            MediaManager.get().upload(imageUri)
                    .callback(new UploadCallback() {
                        @Override
                        public void onStart(String requestId) {

                        }

                        @Override
                        public void onProgress(String requestId, long bytes, long totalBytes) {

                        }

                        @Override
                        public void onSuccess(String requestId, Map resultData) {

                            progressBar.setVisibility(View.GONE);
                            btnSubmitRequest.setEnabled(true);

                            Toast.makeText(RequestActivity.this,
                                    "Request Submitted",
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(String requestId, ErrorInfo error) {
                            progressBar.setVisibility(View.GONE);
                            btnSubmitRequest.setEnabled(true);

                            Toast.makeText(RequestActivity.this,
                                    "Upload failed",
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onReschedule(String requestId, ErrorInfo error) {

                        }
                    })
                    .dispatch();


        });


    }
}