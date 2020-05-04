package com.example.android3a.presentation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.android3a.Singletons;
import com.example.android3a.data.CovidAPI;
import com.example.android3a.presentation.model.Countries;
import com.example.android3a.presentation.view.DetailCountry_Activity;
import com.example.android3a.presentation.view.covidActivity2;
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

public class covidController {

    private covidActivity2 view;
    private Gson gson;
    private SharedPreferences sharedPreferences;
    public static List<Countries> countriesList;
    private static final String BASE_URL = "https://api.covid19api.com/";


    public covidController(covidActivity2 view, Gson gson, SharedPreferences sharedPreferences) {
        this.view = view;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
    }

    public void onStart() {

        countriesList = getDatafromCache();

        if (countriesList != null) {
            view.showList(countriesList);
        } else {
            makeApiCall();
        }


    }

    public void saveList(List<Countries> countriesList) {

        String jsonString = gson.toJson(countriesList);

        sharedPreferences
                .edit()
                .putString("jsonCountriesList", jsonString)
                .apply();

        Toast.makeText(view.getApplicationContext(), "List Saved", Toast.LENGTH_SHORT).show();

    }

    public void makeApiCall() {

        Call<covidActivity2.RestSummaryResponse> call = Singletons.getCovidAPI().getSummaryResponse();
        call.enqueue(new Callback<covidActivity2.RestSummaryResponse>() {
            @Override
            public void onResponse(Call<covidActivity2.RestSummaryResponse> call, Response<covidActivity2.RestSummaryResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CovidAPI.Global global = response.body().getGlobal();
                    List<Countries> countriesList = response.body().getCountries();
                    String date = response.body().getDate();
                    saveList(countriesList);
                    view.showList(countriesList);

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

    public List<Countries> getDatafromCache() {
        String jsonCountries = sharedPreferences.getString("jsonCountriesList", null);
        if (jsonCountries == null) {
            return null;
        } else {

            Type listType = new TypeToken<List<Countries>>() {
            }.getType();
            return gson.fromJson(jsonCountries, listType);
        }
    }

}
