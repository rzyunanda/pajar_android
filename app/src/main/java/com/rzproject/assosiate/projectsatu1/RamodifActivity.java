package com.rzproject.assosiate.projectsatu1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RamodifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramodif);
        String title = "Rawat Modifikasi";
        getSupportActionBar().setTitle(title);
    }
}
