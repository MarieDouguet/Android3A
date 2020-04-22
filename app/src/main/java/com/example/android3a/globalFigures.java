package com.example.android3a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class globalFigures extends AppCompatActivity {


    private static final String BASE_URL = "https://api.covid19api.com/";
    private static final String TAG = "globalFigures";

    private Global global;
    SharedPreferences sharedPreferences;
    Gson gson;
    private TextView Text;
    private AdapterView adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_figures);

        sharedPreferences = getSharedPreferences("application_esiea", Context.MODE_PRIVATE);
        gson = new GsonBuilder()
                .setLenient()
                .create();

        Global global = getDatafromCache();

        makeApiCall();
    }

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_global_figures, container, false);
    }


    private Global getDatafromCache() {
        String jsonGlobal = sharedPreferences.getString("jsonGlobal", null);
        if (jsonGlobal == null) {
            return null;
        } else {

            Type global = new TypeToken<Global>() {
            }.getType();
            return gson.fromJson(jsonGlobal, global);
        }
    }


    public void setAdapter(AdapterView adapter){

    }
    private void showObject(Global global) {
        Text = (TextView) findViewById(R.id.textView2);


    }

    private void makeApiCall() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CovidAPI covidAPI = retrofit.create(CovidAPI.class);

        Call<RestSummaryResponse> call = covidAPI.getSummaryResponse();
        call.enqueue(new Callback<RestSummaryResponse>() {
            @Override
            public void onResponse(Call<RestSummaryResponse> call, Response<RestSummaryResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Global global = response.body().getGlobal();
                    saveObject(global);
                    showObject(global);
                } else {
                    showError();
                }

            }

            @Override
            public void onFailure(Call<RestSummaryResponse> call, Throwable t) {

                showError();
            }
        });
    }

    private void saveObject(Global global) {

        String jsonString = gson.toJson(global);

        sharedPreferences
                .edit()
                .putString("jsonGlobalFigures", jsonString)
                .apply();

        Toast.makeText(getApplicationContext(), "Figures Saved", Toast.LENGTH_SHORT).show();

    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "API error", Toast.LENGTH_SHORT).show();

    }

}
