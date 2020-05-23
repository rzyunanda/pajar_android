package com.rzproject.assosiate.projectsatu1.Activity.Login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.location.Location;
import android.provider.Settings;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.Manifest;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.rzproject.assosiate.projectsatu1.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSimpan;
    private Button btngetlocation;
    LocationManager locationManager;
    String latitude, longtitude;
    EditText editTextLokasi;
    private static  final  int REQUEST_LOCATION =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title = "Daftar Akun";
        getSupportActionBar().setTitle(title);
        setContentView(R.layout.activity_sign_up);

        btnSimpan = (Button) findViewById(R.id.Daftar);
        btnSimpan.setOnClickListener(this);
        editTextLokasi = findViewById(R.id.editTextLokasi);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        btngetlocation = (Button) findViewById(R.id.buttongetlocation);
        btngetlocation.setOnClickListener(this);

    }

    private void buildAlertMessageNoGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setMessage("Hidupkan GPS mu")
                .setCancelable(false)
                .setPositiveButton("YA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(SignUpActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(SignUpActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(SignUpActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
                //Toast.makeText(SignUpActivity.this, "lokasi gagal", Toast.LENGTH_SHORT).show();
            } else {
                Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                if (location != null) {
                    double lat = location.getLatitude();
                    double lng = location.getLongitude();
                    latitude = String.valueOf(lat);
                    longtitude = String.valueOf(lng);
                    editTextLokasi.setText("Latitude" + latitude + ", longitute" + longtitude);
                } else {
                    Toast.makeText(SignUpActivity.this, "lokasi gagal", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null) {
                double lat = location.getLatitude();
                double lng = location.getLongitude();
                latitude = String.valueOf(lat);
                longtitude = String.valueOf(lng);
                editTextLokasi.setText("Latitude" + latitude + ", longitute" + longtitude);
            } else {
                Toast.makeText(SignUpActivity.this, "lokasi gagal", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Daftar:
                simpanButtonClicked();
                break;
            case R.id.buttongetlocation:
                locationButtonClicked();
                break;
        }
    }

    private void simpanButtonClicked() {
        Intent i = new Intent(SignUpActivity.this,MainActivity.class);
        startActivity(i);

    }
    private void locationButtonClicked(){
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGPS();
        } else {
            getLocation();
        }
    }
}
