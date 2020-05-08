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
import android.widget.TextView;
import android.widget.Toast;

import com.example.android3a.R;
import com.example.android3a.Singletons;
import com.example.android3a.presentation.controller.globalFiguresController;
import com.example.android3a.presentation.model.Global;
import com.google.android.material.navigation.NavigationView;


public class globalFigures extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_figures);


        globalFiguresController controller = new globalFiguresController(
                this,
                Singletons.getGson(),
                Singletons.getSharedPreferences(getApplicationContext())
        );

        controller.onStart();

        Toolbar toolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout3);
        NavigationView navigationView = findViewById(R.id.navigation_view3);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);

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
            case R.id.countries:
                intent = new Intent(getApplicationContext(), covidActivity2.class);
                startActivity(intent);
                finish();
                return true;
        }

        return true;
    }

    public void showGlobal(Global global) {
        TextView text2 = findViewById(R.id.textView2);
        TextView text3 = findViewById(R.id.textView3);
        TextView text4 = findViewById(R.id.textView4);
        TextView text5 = findViewById(R.id.textView5);
        TextView text6 = findViewById(R.id.textView6);
        TextView text7 = findViewById(R.id.textView7);
        TextView text8 = findViewById(R.id.textView8);

        text2.setText(global.getNewConfirmed());
        text3.setText(global.getNewDeaths());
        text4.setText(global.getNewRecovered());
        text5.setText(global.getTotalConfirmed());
        text6.setText(global.getTotalDeaths());
        text7.setText(global.getTotalRecovered());
        text8.setText(global.getDate());

    }

    public void showError() {
        Toast.makeText(getApplicationContext(), "API error", Toast.LENGTH_SHORT).show();

    }

}
