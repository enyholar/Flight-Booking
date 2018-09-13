package com.gideondev.safeboda.flightSearch.presenter.presenter_view;

import android.app.DatePickerDialog;

import com.gideondev.safeboda.base.presenter.Presenter;
import com.gideondev.safeboda.model.AirportItem;
import com.gideondev.safeboda.model.cities.CityItem;

public interface FlightSearchPresenter extends Presenter<FlightSearchView> {
    void initData();

    void start();
  //  void getAirPortPerCity(String city);

    AirportItem getOriginCityModel(AirportItem originCities);

    AirportItem getDestinationCityModel(AirportItem destinationCities);

    String getDate(int day,int month, int year);

    void searchForFlight();

    void getTokenFromService();
}
