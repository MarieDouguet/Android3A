package com.example.android3a.data;

import com.example.android3a.presentation.model.Countries;

import java.util.List;

public interface CovidCallback {

    void onSuccess(List<Countries> response);

    void onFailed();


}
