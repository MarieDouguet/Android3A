package com.example.android3a.presentation.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android3a.R;
import com.google.android.material.navigation.NavigationView;

public class MemeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;

    private String[] imageUrls = new String[]{
            "https://static.hitek.fr/img/up_o/1348300528/topmemecoronavirus3.jpg",
            "https://static.hitek.fr/img/up_o/1830308727/topmemecoronavirus4.jpg",
            "https://static.hitek.fr/img/up_o/1288621217/topmemecoronavirus6.jpg",
            "https://static.hitek.fr/img/up_o/675986572/topmemecoronavirus5.jpg",
            "https://static.hitek.fr/img/up_o/2079839901/topmemecoronavirus13.jpg",
            "https://static.hitek.fr/img/up_o/1873668577/topmemecoronavirus40.jpg",
            "https://static.hitek.fr/img/up_o/1128455953/topmemecoronavirus38.jpg",
            "https://static.hitek.fr/img/up_o/1228043602/topmemecoronavirus32.jpg",
            "https://static.hitek.fr/img/up_o/380253503/topmemecoronavirus31.jpg",
            "https://static.hitek.fr/img/up_o/1315166932/topmemecoronavirus30.jpg",
            "https://static.hitek.fr/img/up_o/1978518405/topmemecoronavirus26.jpg",
            "https://static.hitek.fr/img/up_o/750337387/topmemecoronavirus24.jpg",
            "https://static.hitek.fr/img/up_o/1884927976/topmemecoronavirus23.jpg",
            "https://static.hitek.fr/img/up_o/1684235704/topmemecoronavirus20.jpg",
            "https://static.hitek.fr/img/up_o/168354412/topmemecoronavirus21.jpg",
            "https://static.hitek.fr/img/up_o/1643082380/topmemecoronavirus15.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);

        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);


        // concernant la navigation view :
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout6);
        navigationView = (NavigationView) findViewById(R.id.navigation_view6);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

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
            case R.id.countries:
                intent = new Intent(getApplicationContext(), covidActivity2.class);
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

}
