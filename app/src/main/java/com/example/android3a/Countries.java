package com.example.android3a;

import java.text.DateFormat;

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
    private DateFormat Date;

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

    public DateFormat getDate() {
        return Date;
    }
}
