package com.gideondev.safeboda.mapTrack.presenter.presenterView;

import android.location.Location;

import com.gideondev.safeboda.base.presenter.Presenter;
import com.google.android.gms.maps.GoogleMap;

import java.util.List;

public interface MapLocationTrackPresenter extends Presenter<MapLocationTrackView> {
    void getData();


    void setMap(GoogleMap mMap);
}
