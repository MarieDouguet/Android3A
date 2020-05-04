package com.example.android3a.presentation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.android3a.data.CovidAPI;
import com.example.android3a.presentation.view.DetailCountry_Activity;
import com.example.android3a.presentation.view.ListAdapter;
import com.example.android3a.presentation.view.covidActivity2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class covidController {

    private List<DetailCountry_Activity.Countries> countriesList;
    private SharedPreferences sharedPreferences;
    private Gson gson;
    private covidActivity2 view;
    private static final String BASE_URL = "https://api.covid19api.com/";
    private ListAdapter mAdapter;


    public covidController(covidActivity2 covidActivity2, Gson gson, SharedPreferences sharedPreferences){
        this.view = covidActivity2;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;

    }

    public void onStart(){

        countriesList = getDatafromCache();

        if (countriesList != null) {
            view.showList(countriesList);
        } else {
            makeApiCall();
        }

    }

    public void filter(String text){
        ArrayList<DetailCountry_Activity.Countries> filteredList = new ArrayList<>();

        for(DetailCountry_Activity.Countries item : countriesList){
            if (item.getCountry().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        mAdapter.filteredList(filteredList);
    }

    public void makeApiCall() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CovidAPI covidAPI = retrofit.create(CovidAPI.class);

        Call<covidActivity2.RestSummaryResponse> call = covidAPI.getSummaryResponse();
        call.enqueue(new Callback<covidActivity2.RestSummaryResponse>() {
            @Override
            public void onResponse(Call<covidActivity2.RestSummaryResponse> call, Response<covidActivity2.RestSummaryResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CovidAPI.Global global = response.body().getGlobal();
                    List<DetailCountry_Activity.Countries> countriesList = response.body().getCountries();
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

    private void saveList(List<DetailCountry_Activity.Countries> countriesList) {

        String jsonString = gson.toJson(countriesList);

        sharedPreferences
                .edit()
                .putString("jsonCountriesList", jsonString)
                .apply();

    }

    private List<DetailCountry_Activity.Countries> getDatafromCache() {
        String jsonCountries = sharedPreferences.getString("jsonCountriesList", null);
        if (jsonCountries == null) {
            return null;
        } else {

            Type listType = new TypeToken<List<DetailCountry_Activity.Countries>>() {
            }.getType();
            return gson.fromJson(jsonCountries, listType);
        }
    }

    public void onItemClick(){

    }

}
