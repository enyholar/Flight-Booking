package com.gideondev.safeboda.mapTrack.view;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.gideondev.safeboda.R;
import com.gideondev.safeboda.base.presenter.Presenter;
import com.gideondev.safeboda.internal.di.component.DaggerProjectComponent;
import com.gideondev.safeboda.internal.di.module.ProjectModule;
import com.gideondev.safeboda.mapTrack.presenter.presenterView.MapLocationTrackPresenter;
import com.gideondev.safeboda.mapTrack.presenter.presenterView.MapLocationTrackView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

import javax.inject.Inject;

public class FlightRouteDetailsActivity extends FragmentActivity implements OnMapReadyCallback, MapLocationTrackView {
    private SupportMapFragment mapFragment;
    @Inject
    MapLocationTrackPresenter presenter;
    private Marker mUserMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        initPermission();
        injectInjector();
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    protected void injectInjector() {
        DaggerProjectComponent.builder()
                .projectModule(new ProjectModule(this))
                .build()
                .inject(this);
        presenter.setView(this);
        presenter.getData();

    }

    private void initPermission(){
        if (!hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION) && !hasPermissions(this, Manifest.permission.ACCESS_COARSE_LOCATION) && !hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            requestPermission();
        }
    }


    private void requestPermission(){
        ActivityCompat.requestPermissions(FlightRouteDetailsActivity.this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted..
                } else {

                    // permission denied.
                    Toast.makeText(FlightRouteDetailsActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        presenter.setMap(googleMap);
    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showLineLoading() {

    }

    @Override
    public void hideLineLoading() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context getContext() {
        return this;
    }
}
