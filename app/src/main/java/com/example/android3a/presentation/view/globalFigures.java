package com.example.android3a.presentation.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android3a.R;
import com.example.android3a.data.CovidAPI;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class globalFigures extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private static final String BASE_URL = "https://api.covid19api.com/";

    SharedPreferences sharedPreferences;
    Gson gson;
    private TextView Text2;
    private TextView Text3;
    private TextView Text4;
    private TextView Text5;
    private TextView Text6;
    private TextView Text7;
    private TextView Text8;

    private AdapterView adapter;
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_figures);

        sharedPreferences = getSharedPreferences("application_esiea", Context.MODE_PRIVATE);
        gson = new GsonBuilder()
                .setLenient()
                .create();

        CovidAPI.Global global = getDatafromCache();

        if (global!= null) {
            showGlobal(global);
        } else {
            makeApiCall();
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout3);
        navigationView = (NavigationView) findViewById(R.id.navigation_view3);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.isChecked()) {
            menuItem.setChecked(false);
        } else {
            menuItem.setChecked(true);
        }

        mDrawerLayout.closeDrawer(GravityCompat.START, false);

        switch (menuItem.getItemId()) {

            case R.id.menu_principal:
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.useful_links:
                intent = new Intent(getApplicationContext(), LinksActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.a_propos:
                intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.countries:
                intent = new Intent(getApplicationContext(), covidActivity2.class);
                startActivity(intent);
                finish();
                return true;
        }

        return true;
    }


    private CovidAPI.Global getDatafromCache() {
        String jsonGlobal = sharedPreferences.getString("jsonGlobal", null);
        if (jsonGlobal == null) {
            return null;
        } else {

            Type global = new TypeToken<CovidAPI.Global>() {
            }.getType();
            return gson.fromJson(jsonGlobal, global);
        }
    }

    private void showGlobal(CovidAPI.Global global) {
        Text2 = (TextView) findViewById(R.id.textView2);
        Text3 = (TextView) findViewById(R.id.textView3);
        Text4 = (TextView) findViewById(R.id.textView4);
        Text5 = (TextView) findViewById(R.id.textView5);
        Text6 = (TextView) findViewById(R.id.textView6);
        Text7 = (TextView) findViewById(R.id.textView7);
        Text8 = (TextView) findViewById(R.id.textView8);

        Text2.setText(global.getNewConfirmed());
        Text3.setText(global.getNewDeaths());
        Text4.setText(global.getNewRecovered());
        Text5.setText(global.getTotalConfirmed());
        Text6.setText(global.getTotalDeaths());
        Text7.setText(global.getTotalRecovered());
        Text8.setText(global.getDate());

    }

    private void makeApiCall() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CovidAPI covidAPI = retrofit.create(CovidAPI.class);

        Call<covidActivity2.RestSummaryResponse> call = covidAPI.getSummaryResponse();
        call.enqueue(new Callback<covidActivity2.RestSummaryResponse>() {
            @Override
            public void onResponse(Call<covidActivity2.RestSummaryResponse> call, Response<covidActivity2.RestSummaryResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CovidAPI.Global global = response.body().getGlobal();
                    saveObject(global);
                    showGlobal(global);
                } else {
                    showError();
                }

            }

            @Override
            public void onFailure(Call<covidActivity2.RestSummaryResponse> call, Throwable t) {

                showError();
            }
        });
    }

    private void saveObject(CovidAPI.Global global) {

        String jsonString = gson.toJson(global);

        sharedPreferences
                .edit()
                .putString("jsonGlobalFigures", jsonString)
                .apply();

        Toast.makeText(getApplicationContext(), "Figures Saved", Toast.LENGTH_SHORT).show();

    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "API error", Toast.LENGTH_SHORT).show();

    }

}
