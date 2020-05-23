package com.rzproject.assosiate.projectsatu1.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rzproject.assosiate.projectsatu1.Activity.HomeActivity;
import com.rzproject.assosiate.projectsatu1.ApiHelper.BaseApiService;
import com.rzproject.assosiate.projectsatu1.R;
import com.rzproject.assosiate.projectsatu1.SharedPreferences.SharedPrefManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login;
    private Button btn_signup;
    private TextView text_forgetpassword;
    BaseApiService baseApiService;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        btn_signup =  findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);

        text_forgetpassword= findViewById(R.id.text_forgetpassword);
        text_forgetpassword.setOnClickListener(this);
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
            case R.id.text_forgetpassword:
                forgotPasswordClicked();
                break;
        }
    }

    private void loginButtonClicked() {
        Intent i = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(i);

    }

    private void sigUpButtonClicked() {
        Intent i = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(i);
    }

    private void forgotPasswordClicked() {
        Intent i = new Intent(MainActivity.this,ForgotPassword.class);
        startActivity(i);
    }


}
