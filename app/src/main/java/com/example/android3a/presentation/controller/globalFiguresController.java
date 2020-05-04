package com.example.android3a.presentation.controller;

import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.android3a.Singletons;
import com.example.android3a.data.CovidAPI;
import com.example.android3a.presentation.view.covidActivity2;
import com.example.android3a.presentation.view.globalFigures;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class globalFiguresController {

    private globalFigures view;
    private Gson gson;
    private SharedPreferences sharedPreferences;



    public globalFiguresController(globalFigures view, Gson gson, SharedPreferences sharedPreferences){
            this.view= view;
            this.gson=gson;
            this.sharedPreferences=sharedPreferences;
    }

    public void onStart() {
        CovidAPI.Global global = getDatafromCache();

        if (global!= null) {
            view.showGlobal(global);
        } else {
            makeApiCall();
        }
    }

    private CovidAPI.Global getDatafromCache() {
        String jsonGlobal = sharedPreferences.getString("jsonGlobal", null);
        if (jsonGlobal == null) {
            return null;
        } else {

            Type global = new TypeToken<CovidAPI.Global>() {
            }.getType();
            return gson.fromJson(jsonGlobal, global);
        }
    }

    private void makeApiCall() {



        Call<covidActivity2.RestSummaryResponse> call = Singletons.getCovidAPI().getSummaryResponse();
        call.enqueue(new Callback<covidActivity2.RestSummaryResponse>() {
            @Override
            public void onResponse(Call<covidActivity2.RestSummaryResponse> call, Response<covidActivity2.RestSummaryResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CovidAPI.Global global = response.body().getGlobal();
                    saveObject(global);
                    view.showGlobal(global);
                } else {
                    view.showError();
                }

            }

            @Override
            public void onFailure(Call<covidActivity2.RestSummaryResponse> call, Throwable t) {
                view.showError();
            }
        });
    }

    private void saveObject(CovidAPI.Global global) {

        String jsonString = gson.toJson(global);

        sharedPreferences
                .edit()
                .putString("jsonGlobalFigures", jsonString)
                .apply();

        Toast.makeText(view.getApplicationContext(), "Figures Saved", Toast.LENGTH_SHORT).show();

    }
}
