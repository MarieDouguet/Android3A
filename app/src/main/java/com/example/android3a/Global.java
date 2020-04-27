package com.example.android3a;

public class Global {

    private Integer NewConfirmed;
    private Integer TotalConfirmed;
    private Integer NewDeaths;
    private Integer TotalDeaths;
    private Integer NewRecovered;
    private Integer TotalRecovered;


    public String getNewConfirmed() {
        return "New cases confirmed : " + NewConfirmed + " people";
    }

    public String getTotalConfirmed() {
        return "Total confirmed : " + TotalConfirmed+ " people";
    }

    public String getNewDeaths() {

        return "New dead : " + NewDeaths + " people";

    }

    public String getTotalDeaths() {

        return "Total dead : " + TotalDeaths + " people";
    }

    public String getNewRecovered() {

        return "New recovered people : " + NewRecovered + " people";
    }

    public String getTotalRecovered() {

        return "Total recovered people : " + TotalRecovered + " people";
    }
}
