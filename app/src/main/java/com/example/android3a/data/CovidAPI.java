package com.example.android3a.data;

import com.example.android3a.presentation.model.RestSummaryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidAPI {
    @GET("summary")
    Call<RestSummaryResponse> getSummaryResponse();

}
