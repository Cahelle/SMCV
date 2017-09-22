package com.example.laptopcahelle.csi_week_1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Button btn = (Button) findViewById(R.id.backBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ReportActivity.this, MainActivity.class);
                ReportActivity.this.startActivity(intent);
            }
        });
    }

    public void cameraPermission(View view) {
        int cameraPermission = 8888;

        // Assume thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(ReportActivity.this,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(ReportActivity.this,
                    new String[]{Manifest.permission.CAMERA},
                    cameraPermission);
        } else if (ContextCompat.checkSelfPermission(ReportActivity.this,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }
}
