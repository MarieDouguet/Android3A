package com.example.android3a;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RestSummaryResponse implements Parcelable {

    Global Global;
    private List<Countries> Countries;
    Date date = new Date();


    protected RestSummaryResponse(Parcel in) {
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

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dtStr = formatter.format(date);
        return dtStr;
    }


    public Global getGlobal() {
        return Global;
    }

    public List<com.example.android3a.Countries> getCountries() {
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

