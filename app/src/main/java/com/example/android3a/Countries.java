package com.example.android3a;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class Countries {

    private String Countries;
    private String CountryCode;
    private String Slug;
    private Integer NewConfirmed;
    private Integer TotalConfirmed;
    private Integer NewDeaths;
    private Integer TotalDeaths;
    private Integer NewRecovered;
    private Integer TotalRecovered;
    Date date = new Date();

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dtStr = formatter.format(date);
        return dtStr;
    }

    public String getCountries() {
        return Countries;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getSlug() {
        return Slug;
    }

    public Integer getNewConfirmed() {
        return NewConfirmed;
    }

    public Integer getTotalConfirmed() {
        return TotalConfirmed;
    }

    public Integer getNewDeaths() {
        return NewDeaths;
    }

    public Integer getTotalDeaths() {
        return TotalDeaths;
    }

    public Integer getNewRecovered() {
        return NewRecovered;
    }

    public Integer getTotalRecovered() {
        return TotalRecovered;
    }

}
