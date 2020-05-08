package com.example.android3a.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class RestSummaryResponse implements Parcelable {

    private Global Global;
    private List<Countries> Countries;

    public RestSummaryResponse(com.example.android3a.presentation.model.Global global, List<com.example.android3a.presentation.model.Countries> countries) {
        Global = global;
        Countries = countries;
    }

    private RestSummaryResponse(Parcel in) {
    }

    public static final Creator<RestSummaryResponse> CREATOR = new Creator<RestSummaryResponse>() {
        @Override
        public RestSummaryResponse createFromParcel(Parcel in) {
            return new RestSummaryResponse(in);
        }

        @Override
        public RestSummaryResponse[] newArray(int size) {
            return new RestSummaryResponse[size];
        }
    };



    public Global getGlobal() {
        return Global;
    }

    public List<Countries> getCountries() {
        return Countries;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}