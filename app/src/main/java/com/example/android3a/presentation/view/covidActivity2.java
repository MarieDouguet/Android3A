package com.example.android3a.presentation.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android3a.R;
import com.example.android3a.Singletons;
import com.example.android3a.presentation.controller.covidController;
import com.example.android3a.presentation.model.Countries;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class covidActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;

    private ListAdapter mAdapter;

    covidController controller;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);


        controller = new covidController(
                this,
                Singletons.getGson(),
                Singletons.getSharedPreferences(getApplicationContext())
        );
        controller.onStart();


        mDrawerLayout =  findViewById(R.id.drawer_layout4);
        NavigationView navigationView = findViewById(R.id.navigation_view4);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        EditText editText = findViewById(R.id.edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }

    public void filter(String text) {
        ArrayList<Countries> filteredList = new ArrayList<>();
        List<Countries> countriesList = covidController.countriesList;

        for (Countries item : countriesList) {
            if (item.getCountry().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mAdapter.filteredList(filteredList);
    }
    //Menu sur le côté
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
        }

        return true;
    }

    public void showList(List<Countries> countriesList) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ListAdapter(countriesList, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Countries values) {

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


}
