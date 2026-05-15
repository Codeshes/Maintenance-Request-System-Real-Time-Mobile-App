package com.example.maintenancerequestsystemreal_timemobileapp;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Map;
import java.util.HashMap;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RequestActivity extends AppCompatActivity {

    Toolbar tb;
    EditText etRequestTitle, etLocation, etDescription;
    Button btnSubmitRequest, btnUploadImage;
    DatabaseReference dataBaseReference;

    ImageView imgPreview;
    CardView cardImagePreview;

    ProgressBar progressBar;

    Uri imageUri;

    ActivityResultLauncher<String> imagePickerLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        tb = findViewById(R.id.toolbar);
        tb.setNavigationOnClickListener(v -> finish());

        etRequestTitle = findViewById(R.id.etRequestTitle);
        etLocation = findViewById(R.id.etLocation);
        etDescription = findViewById(R.id.etDescription);

        btnSubmitRequest = findViewById(R.id.btnSubmitRequest);
        btnUploadImage = findViewById(R.id.btnUploadImage);

        imgPreview = findViewById(R.id.imgPreview);
        cardImagePreview = findViewById(R.id.cardImagePreview);

        progressBar = findViewById(R.id.progressBar);

        initCloudinary();

        dataBaseReference =
                FirebaseDatabase.
                        getInstance()
                        .getReference("requests");

        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts
                        .GetContent(),
                uri -> {
                    if (uri != null) {
                        imageUri = uri;
                        imgPreview.setImageURI(uri);
                        cardImagePreview.setVisibility(View.VISIBLE);
                        Toast.makeText(this,
                                        "Image Selected",
                                        Toast.LENGTH_SHORT)
                                .show();
                    }
                }
        );

        btnUploadImage.setOnClickListener(v -> imagePickerLauncher.launch("image/*"));

        btnSubmitRequest.setOnClickListener(v -> {

            validateAndUpload();
        });

    }

    private void validateAndUpload() {

        String title =
                etRequestTitle.getText().toString().trim();
        String location =
                etLocation.getText().toString().trim();
        String description =
                etDescription.getText().toString().trim();

        if (title.isEmpty()) {
            etRequestTitle.setError("Required");
            return;
        }

        if (location.isEmpty()) {
            etLocation.setError("Required");
            return;
        }

        if (description.isEmpty()) {
            etDescription.setError("Required");
            return;
        }

        if (imageUri == null) {
            Toast.makeText(this,
                            "Select image",
                            Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        uploadToCloudinary();
    }

    private void uploadToCloudinary() {

        btnSubmitRequest.setText("");
        progressBar.setVisibility(View.VISIBLE);
        btnSubmitRequest.setEnabled(false);

        MediaManager.get().upload(imageUri)
                .unsigned("maintenancepreset")
                .callback(new UploadCallback() {

                    @Override
                    public void onStart(String requestId) {

                    }

                    @Override
                    public void onProgress(String requestId, long bytes, long totalBytes) {

                    }

                    @Override
                    public void onSuccess(String requestId, Map resultData) {

                        String imageUrl =
                                resultData
                                        .get("secure_url")
                                        .toString();

                        saveToFirebase(imageUrl);
                    }

                    @Override
                    public void onError(String requestId, ErrorInfo error) {

                        btnSubmitRequest.setText("Submit Request");
                        progressBar.setVisibility(View.GONE);
                        btnSubmitRequest.setEnabled(true);

                        Toast.makeText(RequestActivity.this,
                                error.getDescription(),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onReschedule(String requestId, ErrorInfo error) {

                    }
                })
                .dispatch();
    }

    private void saveToFirebase(String imageUrl) {

        String title =
                etRequestTitle.getText().toString().trim();
        String location =
                etLocation.getText().toString().trim();
        String description =
                etDescription.getText().toString().trim();

        String id = dataBaseReference.push().getKey();

        HelperClassRequest request = new HelperClassRequest(
                title,
                location,
                description,
                imageUrl,
                "Pending"
        );

        dataBaseReference.child(id)
                .setValue(request)

                .addOnSuccessListener(unused -> {

                    btnSubmitRequest.setText("Submit Request");
                    progressBar.setVisibility(View.GONE);
                    btnSubmitRequest.setEnabled(true);

                    Toast.makeText(this,
                                    "Request Uploaded",
                                    Toast.LENGTH_SHORT)
                            .show();

                    clearFields();
                })
                .addOnFailureListener(e -> {

                    btnSubmitRequest.setText("Submit Request");
                    progressBar.setVisibility(View.GONE);
                    btnSubmitRequest.setEnabled(true);

                    Toast.makeText(this,
                                    e.getMessage(),
                                    Toast.LENGTH_SHORT)
                            .show();
                });
    }

    private void initCloudinary() {
        try {
            Map<String, String> config = new HashMap<>();
            config.put("cloud_name", "dlytd1gjp");
            MediaManager.init(this, config);
        } catch (IllegalStateException e) {
            // MM Already initialized
        }
    }

    private void clearFields() {
        etRequestTitle.setText("");
        etLocation.setText("");
        etDescription.setText("");
        imageUri = null;
        cardImagePreview.setVisibility(View.GONE);
    }
}