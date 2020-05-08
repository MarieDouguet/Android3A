package com.example.android3a.presentation.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android3a.R;
import com.google.android.material.navigation.NavigationView;

public class LinksActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        // concernant la navigation view :
        Toolbar toolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout5);
        NavigationView navigationView = findViewById(R.id.navigation_view5);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);

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
            case R.id.memes:
                intent = new Intent(getApplicationContext(), MemeActivity.class);
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
