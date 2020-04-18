package com.example.android3a;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

class CovidActivity extends AppCompatActivity {

    private static final String TAG = "CovidActivity";

    protected void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().hasExtra("selected_country")) {
            RestSummaryResponse covid = getIntent().getParcelableExtra("selected_country");
            Log.d(TAG, "OnCreate:" + covid.toString());
        }
        
    }
}
