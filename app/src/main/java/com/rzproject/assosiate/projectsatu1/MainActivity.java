package com.rzproject.assosiate.projectsatu1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login;
    private Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                loginButtonClicked();
                break;
            case R.id.btn_signup:
                sigUpButtonClicked();
                break;
        }
    }

    private void loginButtonClicked() {
        Intent i = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(i);

    }

    private void sigUpButtonClicked() {
        Intent i = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(i);
    }
}
