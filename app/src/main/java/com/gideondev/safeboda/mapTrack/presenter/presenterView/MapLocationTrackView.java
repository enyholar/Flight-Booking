package com.gideondev.safeboda.mapTrack.presenter.presenterView;

import android.app.Activity;

import com.gideondev.safeboda.base.presenter.LoadDataView;
import com.gideondev.safeboda.base.presenter.Presenter;


public interface MapLocationTrackView extends LoadDataView {
    Presenter getPresenter();

    Activity getActivity();

}
