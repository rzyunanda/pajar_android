package com.rzproject.assosiate.projectsatu1.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import com.rzproject.assosiate.projectsatu1.Activity.Detekos.DetekosFragment;
import com.rzproject.assosiate.projectsatu1.Activity.Insting.InstingFragment;
import com.rzproject.assosiate.projectsatu1.Activity.Kongga.KonggaFragment;
import com.rzproject.assosiate.projectsatu1.Activity.Login.MainActivity;
import com.rzproject.assosiate.projectsatu1.Activity.Ramodif.RamodifFragment;
import com.rzproject.assosiate.projectsatu1.ApiHelper.BaseApiService;
import com.rzproject.assosiate.projectsatu1.ApiHelper.UtilsApi;
import com.rzproject.assosiate.projectsatu1.R;
import com.rzproject.assosiate.projectsatu1.SharedPreferences.SharedPrefManager;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public String title = "Beranda";
    InstingFragment instingFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Toolbar toolbar;
    private String accessToken;

    private BaseApiService mApiService;
    private SharedPrefManager sharedPrefManager;
    private JSONObject dataArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPrefManager = new SharedPrefManager(this);
        mApiService = UtilsApi.getAPIService();
        accessToken = sharedPrefManager.getSpToken();

        setActionBarTitle(title);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Dashboard");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        instingFragment = new InstingFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, instingFragment);
        fragmentTransaction.commit();// add the fragment

    }


    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_insting) {
            loadFragment(new InstingFragment());

        } else if (id == R.id.nav_detekos) {
            loadFragment(new DetekosFragment());
        } else if (id == R.id.nav_kongga) {
            loadFragment(new KonggaFragment());

        } else if (id == R.id.nav_ramodif) {
            loadFragment(new RamodifFragment());

        } else if (id == R.id.nav_logout) {
            logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment secondFragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, secondFragment);
        fragmentTransaction.commit();
    }

    private void logout() {
        mApiService.logout(accessToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    sharedPrefManager.saveSPToken("");

                } else {
                    Toast.makeText(HomeActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
