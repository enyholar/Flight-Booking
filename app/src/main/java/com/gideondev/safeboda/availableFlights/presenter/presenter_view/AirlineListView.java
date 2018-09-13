package com.gideondev.safeboda.availableFlights.presenter.presenter_view;

import android.app.Activity;

import com.gideondev.safeboda.base.presenter.LoadDataView;
import com.gideondev.safeboda.model.schedules.ScheduleItem;

import java.util.List;

public interface AirlineListView extends LoadDataView {
    Activity getActivity();
    void notifyAdapter();
    void setUpAdapter(List<ScheduleItem> list);


}
