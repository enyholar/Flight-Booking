package com.gideondev.safeboda.availableFlights.presenter.presenter_implementation;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.gideondev.safeboda.Utility.Constant;
import com.gideondev.safeboda.availableFlights.presenter.presenter_view.AirlineListPresenter;
import com.gideondev.safeboda.availableFlights.presenter.presenter_view.AirlineListView;
import com.gideondev.safeboda.mapTrack.view.FlightRouteDetailsActivity;
import com.gideondev.safeboda.model.schedules.ScheduleItem;
import com.gideondev.safeboda.model.schedules.ScheduleResource;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AirLineListImplementation implements AirlineListPresenter {
    private AirlineListView mView;
    List<ScheduleItem> scheduleFlightList = new ArrayList<>();
    ScheduleResource scheduleResource;
    @Override
    public void initData() {
        Intent intent = mView.getActivity().getIntent();
        String json = intent.getStringExtra(Constant.KEY_SCHEDULE_LIST);
        Gson gson = new Gson();
        Type type = new TypeToken<ScheduleResource>() {
        }.getType();
        scheduleResource = gson.fromJson(String.valueOf(json), type);
        scheduleFlightList.addAll(scheduleResource.getSchedule());
        mView.setUpAdapter(scheduleFlightList);
    }

    @Override
    public void openRouteScreen() {
        Intent intent = new Intent(mView.getContext(), FlightRouteDetailsActivity.class);
        mView.getActivity().startActivity(intent);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void setView(@NonNull AirlineListView view) {
        this.mView = view;
    }
}
