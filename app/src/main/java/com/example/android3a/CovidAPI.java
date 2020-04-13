package com.example.android3a;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidAPI {
    @GET("summary")
    Call<RestSummaryResponse> getSummaryResponse();
}
