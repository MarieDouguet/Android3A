package com.example.android3a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.Date;

public class DetailCountry_Activity extends AppCompatActivity {

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

    DrawerLayout mDrawerLayout;
    NavigationView navigationView;


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

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_detail_country_, container, false);
    }
}
