package com.rzproject.assosiate.projectsatu1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title = "Deteksi Orientasi";
        getSupportActionBar().setTitle(title);
        setContentView(R.layout.activity_start_q);
    }
}