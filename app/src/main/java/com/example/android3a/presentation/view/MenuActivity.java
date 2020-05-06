package com.example.android3a.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android3a.R;
import com.example.android3a.presentation.model.Countries;

import java.util.List;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button button_global;
    Button button_ListOfCountries;
    Button button_search;
    EditText etCountry;
    ProgressBar pbLoader;
    ListView lvRecent;
    private Handler handler;
    List<Countries> countriesList;
    private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.menu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

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

        handler = new Handler();


        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recherche = etCountry.getText().toString().trim();
                if (recherche.length() > 0) {
                    pbLoader.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(getApplicationContext(), covidActivity2.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 2000);

                } else {
                    Toast.makeText(getApplicationContext(), "Enter a country name", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        if (parent.getItemAtPosition(position).equals("Global")){
            intent = new Intent(getApplicationContext(), globalFigures.class);
            startActivity(intent);
            finish();
        }else if (parent.getItemAtPosition(position).equals("Countries")){
            intent = new Intent(getApplicationContext(), covidActivity2.class);
            startActivity(intent);
            finish();
        } else if (parent.getItemAtPosition(position).equals("Useful links")){
            intent = new Intent(getApplicationContext(), LinksActivity.class);
            startActivity(intent);
            finish();
        }else if (parent.getItemAtPosition(position).equals("About the app")) {
            intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);
            finish();
        }else if (parent.getItemAtPosition(position).equals("Memes")){
            intent = new Intent(getApplicationContext(), MemeActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
