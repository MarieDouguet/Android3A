package com.example.android3a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

public class covidActivity2 extends AppCompatActivity {


    private static final String BASE_URL = "https://api.covid19api.com/";
    private static final String TAG = "CovidActivity";

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);


        sharedPreferences = getSharedPreferences("application_esiea", Context.MODE_PRIVATE);
        gson = new GsonBuilder()
                .setLenient()
                .create();

        List<Countries> countriesList = getDatafromCache();

        if (countriesList != null) {
            showList(countriesList);
        } else {
            makeApiCall();
        }
    }

    private List<Countries> getDatafromCache() {
        String jsonCountries = sharedPreferences.getString("jsonCountriesList", null);
        if (jsonCountries == null) {
            return null;
        } else {

            Type listType = new TypeToken<List<Countries>>() {
            }.getType();
            return gson.fromJson(jsonCountries, listType);
        }
    }

    private void showList(List<Countries> countriesList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ListAdapter(countriesList);
        recyclerView.setAdapter(mAdapter);
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
                    List<Countries> countriesList = response.body().getCountries();
                    String date = response.body().getDate();
                    saveList(countriesList);
                    showList(countriesList);

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

    private void saveList(List<Countries> countriesList) {

        String jsonString = gson.toJson(countriesList);

        sharedPreferences
                .edit()
                .putString("jsonCountriesList", jsonString)
                .apply();

        Toast.makeText(getApplicationContext(), "List Saved", Toast.LENGTH_SHORT).show();

    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "API error", Toast.LENGTH_SHORT).show();

    }

    public void onCovidClick(int position) {
        Log.d(TAG, "onCovidClick: clicked.");

        Intent intent = new Intent(getApplicationContext(), covidActivity2.class);
        // intent.putExtra("selected_country", mAdapter.get(position));
        startActivity(intent);
    }
}
