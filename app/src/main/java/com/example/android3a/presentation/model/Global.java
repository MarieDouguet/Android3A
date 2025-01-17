package com.example.android3a.presentation.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Global {

    private Integer NewConfirmed;
    private Integer TotalConfirmed;
    private Integer NewDeaths;
    private Integer TotalDeaths;
    private Integer NewRecovered;
    private Integer TotalRecovered;
    Date date = new Date();


    public String getNewConfirmed() {
        return "New cases confirmed : " + NewConfirmed + " people";
    }

    public String getTotalConfirmed() {
        return "Total confirmed : " + TotalConfirmed+ " people";
    }

    public String getNewDeaths() {

        return "New deaths : " + NewDeaths + " people";

    }

    public String getTotalDeaths() {

        return "Total deaths : " + TotalDeaths + " people";
    }

    public String getNewRecovered() {

        return "New recovered : " + NewRecovered + " people";
    }

    public String getTotalRecovered() {

        return "Total recovered : " + TotalRecovered + " people";
    }



    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dtStr = formatter.format(date);
        return "Updated at : " + dtStr;
    }
}