package com.example.android3a.presentation.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.android3a.R;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;


public class DetailCountry_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView textView_country;
    TextView textView_countryCode;
    TextView textView_NC;
    TextView textView_TC;
    TextView textView_ND;
    TextView textView_TD;
    TextView textView_NR;
    TextView textView_TR;
    TextView textView_date;

    String country;
    String countryCode;
    String NewConfirmed;
    String TotalConfirmed;
    String NewDeaths;
    String TotalDeaths;
    String NewRecovered;
    String TotalRecovered;
    String Date;

    private DrawerLayout mDrawerLayout;
    ImageView picasso;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country_);
        textView_country = findViewById(R.id.textView_Country);
        textView_countryCode = findViewById(R.id.textView_CountryCode);
        textView_NC = findViewById(R.id.textView_NC);
        textView_TC = findViewById(R.id.textView_TC);
        textView_ND = findViewById(R.id.textView_ND);
        textView_TD = findViewById(R.id.textView_TD);
        textView_NR = findViewById(R.id.textView_NR);
        textView_TR = findViewById(R.id.textView_TR);
        textView_date = findViewById(R.id.textView_Date);

        Bundle b = getIntent().getExtras();

        assert b != null;
        country = b.getString("txtHeader");
        countryCode = b.getString("txtFooter");
        NewConfirmed = b.getString("textView_NC");
        TotalConfirmed = b.getString("textView_TC");
        NewDeaths = b.getString("textView_ND");
        TotalDeaths = b.getString("textView_TD");
        NewRecovered = b.getString("textView_NR");
        TotalRecovered = b.getString("textView_TR");
        Date = b.getString("textView_date");

        textView_country.setText(country);
        textView_countryCode.setText(countryCode);
        textView_NC.setText(NewConfirmed);
        textView_TC.setText(TotalConfirmed);
        textView_ND.setText(NewDeaths);
        textView_TD.setText(TotalDeaths);
        textView_NR.setText(NewRecovered);
        textView_TR.setText(TotalRecovered);
        textView_date.setText(Date);

        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle(country.toUpperCase());
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        picasso = findViewById(R.id.picasso);
        String url = "https://www.crwflags.com/art/countries/" + country.toLowerCase() + ".gif";
        Picasso.get()
                .load(url)
                .into(picasso);

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
            case R.id.memes:
                intent = new Intent(getApplicationContext(), MemeActivity.class);
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

}
