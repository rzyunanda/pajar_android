package com.rzproject.assosiate.projectsatu1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login;
    private Button btn_signup;
    private TextView text_forgetpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);

        text_forgetpassword=(TextView) findViewById(R.id.text_forgetpassword);
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
        Intent i = new Intent(MainActivity.this,HomeActivity.class);
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
