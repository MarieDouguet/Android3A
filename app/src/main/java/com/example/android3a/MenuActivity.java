package com.example.android3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button button_global;
    Button button_ListOfCountries;
    Button button_search;
    EditText etCountry;
    ProgressBar pbLoader;
    ListView lvRecent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        button_global = (Button) findViewById(R.id.button_global);
        button_global.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), globalFigures.class);

                startActivity(intent);
            }
        });

        button_ListOfCountries = (Button) findViewById(R.id.button_listOfCountries);
        button_ListOfCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), covidActivity2.class);
                startActivity(intent);
            }
        });

        etCountry = (EditText) findViewById(R.id.et_country);

        button_search = (Button) findViewById(R.id.btn_send);

        pbLoader = (ProgressBar) findViewById(R.id.pb_search);

        lvRecent = (ListView) findViewById(R.id.lv_recent);

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etCountry.getText().toString();
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

}
