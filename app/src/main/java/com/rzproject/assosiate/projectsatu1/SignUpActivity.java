package com.rzproject.assosiate.projectsatu1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title = "Daftar Akun";
        getSupportActionBar().setTitle(title);
        setContentView(R.layout.activity_sign_up);

        btnSimpan = (Button) findViewById(R.id.Daftar);
        btnSimpan.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Daftar:
                simpanButtonClicked();
                break;
        }
    }

    private void simpanButtonClicked() {
        Intent i = new Intent(SignUpActivity.this,MainActivity.class);
        startActivity(i);

    }
}
