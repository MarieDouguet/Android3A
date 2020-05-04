package com.example.android3a.presentation.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android3a.R;
import com.example.android3a.data.CovidAPI;
import com.example.android3a.presentation.controller.covidController;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class covidActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;

    private EditText editText;

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private covidController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);

        controller = new covidController(
                this,
                new GsonBuilder()
                        .setLenient()
                        .create(),
                getSharedPreferences("application_esiea", Context.MODE_PRIVATE)
        );
        controller.onStart();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout4);
        navigationView = (NavigationView) findViewById(R.id.navigation_view4);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        editText = (EditText) findViewById(R.id.edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                controller.filter(s.toString());
            }
        });

    }

    @Override
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
            case R.id.global_figures:
                intent = new Intent(getApplicationContext(), globalFigures.class);
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
        }

        return true;
    }

    public void showList(List<DetailCountry_Activity.Countries> countriesList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ListAdapter(countriesList, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DetailCountry_Activity.Countries values) {

                Intent intent = new Intent(getApplicationContext(), DetailCountry_Activity.class);
                // intent.putExtra("id", id);
                intent.putExtra("txtHeader", values.getCountry());
                intent.putExtra("txtFooter", values.getCountryCode());
                intent.putExtra("textView_NC", values.getNewConfirmed());
                intent.putExtra("textView_TC", values.getTotalConfirmed());
                intent.putExtra("textView_ND", values.getNewDeaths());
                intent.putExtra("textView_TD", values.getTotalDeaths());
                intent.putExtra("textView_NR", values.getNewRecovered());
                intent.putExtra("textView_TR", values.getTotalRecovered());
                intent.putExtra("textView_date", values.getDate());

                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

    public void showError() {
        Toast.makeText(getApplicationContext(), "API error", Toast.LENGTH_SHORT).show();

    }

    public static class RestSummaryResponse implements Parcelable {

        CovidAPI.Global Global;
        private List<DetailCountry_Activity.Countries> Countries;
        Date date = new Date();


        protected RestSummaryResponse(Parcel in) {
        }

        public static final Creator<RestSummaryResponse> CREATOR = new Creator<RestSummaryResponse>() {
            @Override
            public RestSummaryResponse createFromParcel(Parcel in) {
                return new RestSummaryResponse(in);
            }

            @Override
            public RestSummaryResponse[] newArray(int size) {
                return new RestSummaryResponse[size];
            }
        };

        public String getDate() {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String dtStr = formatter.format(date);
            return dtStr;
        }


        public CovidAPI.Global getGlobal() {
            return Global;
        }

        public List<DetailCountry_Activity.Countries> getCountries() {
            return Countries;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }
    }
}
