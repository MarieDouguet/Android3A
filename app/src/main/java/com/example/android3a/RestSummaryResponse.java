package com.example.android3a;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RestSummaryResponse {

    Global global = new Global();
    private List<Countries> Countries;
    Date date = new Date();


    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dtStr = formatter.format(date);
        return dtStr;
    }


    public String getGlobal() {
        return String.valueOf(global.getNewConfirmed());

    }

    public List<com.example.android3a.Countries> getCountries() {
        return Countries;
    }
}

