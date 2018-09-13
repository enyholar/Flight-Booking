package com.gideondev.safeboda.availableFlights.presenter.presenter_view;

import com.gideondev.safeboda.base.presenter.Presenter;

import java.util.List;

public interface AirlineListPresenter extends Presenter<AirlineListView> {

    void initData();

    void openRouteScreen();
}
