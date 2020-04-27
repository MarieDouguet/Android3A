package com.example.android3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = "Menu Activity";
    private Button button_global;
    private Button button_ListOfCountries;


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
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

}
