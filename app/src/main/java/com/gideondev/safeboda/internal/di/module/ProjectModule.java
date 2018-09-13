package com.gideondev.safeboda.internal.di.module;

import android.app.Activity;


import com.gideondev.safeboda.availableFlights.presenter.presenter_implementation.AirLineListImplementation;
import com.gideondev.safeboda.availableFlights.presenter.presenter_view.AirlineListPresenter;
import com.gideondev.safeboda.flightSearch.presenter.presenter_implementation.FlightSearchImplementation;
import com.gideondev.safeboda.flightSearch.presenter.presenter_view.FlightSearchPresenter;
import com.gideondev.safeboda.internal.di.PerActivity;
import com.gideondev.safeboda.mapTrack.presenter.presenterImplementation.MapLocationTrackPresenterImplement;
import com.gideondev.safeboda.mapTrack.presenter.presenterView.MapLocationTrackPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Enny  on 29/11/2016.
 */
@Module(includes = ApplicationModule.class)
public class ProjectModule {

  private final Activity activity;

  public ProjectModule(Activity activity) {
    this.activity = activity;
  }

  @Provides
  @PerActivity
  Activity activity() {
    return this.activity;
  }

  @Provides
  FlightSearchPresenter provideFlightSearchPresenter() {
    return new FlightSearchImplementation();
  }

  @Provides
  AirlineListPresenter provideAirlineListPresenter() {
    return new AirLineListImplementation();
  }

  @Provides
  MapLocationTrackPresenter provideMapLocationTrackPresenter() {
    return new MapLocationTrackPresenterImplement();
  }

}

