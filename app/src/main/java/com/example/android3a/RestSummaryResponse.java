package com.example.android3a;

import java.text.DateFormat;
import java.util.List;

public class RestSummaryResponse {

    private Global global;
    private List<Countries> Countries;


    public Global getGlobal() {
        return global;
    }

    public List<com.example.android3a.Countries> getCountries() {
        return Countries;
    }
}

