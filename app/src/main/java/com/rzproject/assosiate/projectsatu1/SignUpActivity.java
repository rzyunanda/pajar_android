package com.rzproject.assosiate.projectsatu1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title = "Daftar Akun";
        getSupportActionBar().setTitle(title);
        setContentView(R.layout.activity_sign_up);
    }
}
