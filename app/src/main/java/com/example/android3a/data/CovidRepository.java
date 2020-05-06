package com.example.android3a.data;

import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.android3a.presentation.model.Countries;
import com.example.android3a.presentation.model.RestSummaryResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidRepository {

    private final Gson gson;
    private CovidAPI covidAPI;
    private SharedPreferences sharedPreferences;

    public CovidRepository(CovidAPI covidAPI, SharedPreferences sharedPreferences, Gson gson) {
        this.covidAPI = covidAPI;
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    public void getSummaryResponse(final CovidCallback callback){

        List<Countries> list = getDatafromCache();

        if (list != null){
                callback.onSuccess(list);
        }else{
            covidAPI.getSummaryResponse().enqueue(new Callback<RestSummaryResponse>() {
                @Override
                public void onResponse(Call<RestSummaryResponse> call, Response<RestSummaryResponse> response) {
                    if(response.isSuccessful() && response.body() != null){
                        callback.onSuccess(response.body().getCountries());
                    } else{
                        callback.onFailed();
                    }
                }

                @Override
                public void onFailure(Call<RestSummaryResponse> call, Throwable t) {
                    callback.onFailed();
                }
            });

        }

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

    public void saveList(List<Countries> countriesList) {

        String jsonString = gson.toJson(countriesList);

        sharedPreferences
                .edit()
                .putString("jsonCountriesList", jsonString)
                .apply();

    }

}
