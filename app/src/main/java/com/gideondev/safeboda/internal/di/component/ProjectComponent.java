package com.gideondev.safeboda.internal.di.component;


import com.gideondev.safeboda.availableFlights.View.AirLIneListActivity;
import com.gideondev.safeboda.flightSearch.view.FlightSearchActivity;
import com.gideondev.safeboda.internal.di.PerActivity;
import com.gideondev.safeboda.internal.di.module.ProjectModule;
import com.gideondev.safeboda.mapTrack.view.FlightRouteDetailsActivity;

import dagger.Component;

/**
 * Created by Enny on 29/11/2016.
 */
@PerActivity
@Component(modules = ProjectModule.class)
public interface ProjectComponent {
  void inject(FlightSearchActivity flightSearchActivity);
  void inject(AirLIneListActivity mainActivity);
  void inject(FlightRouteDetailsActivity locationDetailsActivity);
}
