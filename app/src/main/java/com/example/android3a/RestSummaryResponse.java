package com.example.android3a;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RestSummaryResponse {

    private Global global;
    private List<Countries> Countries;
    Date date = new Date();

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dtStr = formatter.format(date);
        return dtStr;
    }

    public Global getGlobal() {
        return global;
    }

    public List<com.example.android3a.Countries> getCountries() {
        return Countries;
    }
}

