package com.gideondev.safeboda.flightSearch.presenter.presenter_view;

import android.app.Activity;

import com.gideondev.safeboda.base.presenter.LoadDataView;
import com.gideondev.safeboda.model.AirportItem;
import com.gideondev.safeboda.model.cities.CityItem;

import java.util.List;

public interface FlightSearchView extends LoadDataView {
    Activity getActivity();
    void showOriginDestinationSpinnerData(List<AirportItem> cityItemList);
}
