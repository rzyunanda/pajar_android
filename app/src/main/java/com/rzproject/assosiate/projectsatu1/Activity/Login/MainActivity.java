package com.rzproject.assosiate.projectsatu1.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rzproject.assosiate.projectsatu1.Activity.HomeActivity;
import com.rzproject.assosiate.projectsatu1.ApiHelper.BaseApiService;
import com.rzproject.assosiate.projectsatu1.ApiHelper.UtilsApi;
import com.rzproject.assosiate.projectsatu1.R;
import com.rzproject.assosiate.projectsatu1.SharedPreferences.SharedPrefManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login;
    private Button btn_signup;
    private EditText edt_username, edt_password;
    private TextView text_forgetpassword;
    BaseApiService baseApiService;
    ProgressBar progressBar;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefManager = new SharedPrefManager(this);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        if (sharedPrefManager.getSpToken().equals("")) {
            progressBar = findViewById(R.id.pb_login);

            btn_login = findViewById(R.id.btn_login);
            btn_login.setOnClickListener(this);

            edt_username = findViewById(R.id.ed_username);
            edt_password = findViewById(R.id.ed_password);

            btn_signup = findViewById(R.id.btn_signup);
            btn_signup.setOnClickListener(this);
            baseApiService = UtilsApi.getAPIService();

            text_forgetpassword = findViewById(R.id.text_forgetpassword);
            text_forgetpassword.setOnClickListener(this);

        } else {
            super.onCreate(savedInstanceState);

            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
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
        requestLogin();
        btn_login.setVisibility(View.INVISIBLE);
        btn_signup.setVisibility(View.INVISIBLE);

    }

    private void sigUpButtonClicked() {
        Intent i = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(i);
    }

    private void forgotPasswordClicked() {
        Intent i = new Intent(MainActivity.this, ForgotPassword.class);
        startActivity(i);
    }

    private void requestLogin() {

        progressBar.setVisibility(View.VISIBLE);

        baseApiService.loginRequest(edt_username.getText().toString(), edt_password.getText().toString()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        //Toast.makeText(MainActivity.this, jsonRESULTS.getString("token"), Toast.LENGTH_SHORT).show();
                        String token = "Bearer " + jsonRESULTS.getString("token");
                        sharedPrefManager.saveSPToken(token);

                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();

                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    btn_login.setVisibility(View.VISIBLE);
                    btn_signup.setVisibility(View.VISIBLE);
                    //   relativeLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Wrong username/password.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                btn_login.setVisibility(View.VISIBLE);
                btn_signup.setVisibility(View.VISIBLE);
                //   relativeLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "Error with connection :(", Toast.LENGTH_LONG).show();
            }
        });
    }


}
