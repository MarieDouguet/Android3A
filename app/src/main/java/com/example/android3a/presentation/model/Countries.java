package com.example.android3a.presentation.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Countries {

    private String Country;
    private String CountryCode;
    private Integer NewConfirmed;
    private Integer TotalConfirmed;
    private Integer NewDeaths;
    private Integer TotalDeaths;
    private Integer NewRecovered;
    private Integer TotalRecovered;
    private Date date = new Date();

    public Countries(String country, String countryCode, Integer newConfirmed, Integer totalConfirmed, Integer newDeaths, Integer totalDeaths, Integer newRecovered, Integer totalRecovered) {
        Country = country;
        CountryCode = countryCode;
        NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
        NewDeaths = newDeaths;
        TotalDeaths = totalDeaths;
        NewRecovered = newRecovered;
        TotalRecovered = totalRecovered;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.FRANCE);
        String dtStr = formatter.format(date);
        return "Updated at : " + dtStr;
    }

    public String getCountry() {

        return Country;
    }

    public String getCountryCode() {
        return "Country code : " + CountryCode;
    }


    public String getNewConfirmed() {

        return "New cases confirmed : " + NewConfirmed+ " people";
    }

    public String getTotalConfirmed() {

        return  "Total confirmed : " + TotalConfirmed+ " people";
    }

    public String getNewDeaths() {

        return "New deaths : " + NewDeaths+ " people";
    }

    public String getTotalDeaths() {

        return  "Total deaths : " + TotalDeaths+ " people";
    }

    public String getNewRecovered() {
        return "New recovered : "  + NewRecovered+ " people";
    }

    public String getTotalRecovered() {

        return " Total recovered : " + TotalRecovered+ " people";
    }

}