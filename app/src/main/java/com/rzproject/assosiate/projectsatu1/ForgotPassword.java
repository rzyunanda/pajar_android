package com.rzproject.assosiate.projectsatu1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {
    public Button resetpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        String title = "Reset Password";
        getSupportActionBar().setTitle(title);

        resetpassword= (Button) findViewById(R.id.resetpassword);
        resetpassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.resetpassword:
                resetButtonClicked();
                break;

        }
    }

    private void resetButtonClicked() {
        Intent i = new Intent(ForgotPassword.this,MainActivity.class);
        startActivity(i);

    }
}
