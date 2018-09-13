package com.gideondev.safeboda.availableFlights.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.gideondev.safeboda.R;
import com.gideondev.safeboda.adapter.airlineListAdapter;
import com.gideondev.safeboda.availableFlights.presenter.presenter_view.AirlineListPresenter;
import com.gideondev.safeboda.availableFlights.presenter.presenter_view.AirlineListView;
import com.gideondev.safeboda.base.BaseActionbarActivity;
import com.gideondev.safeboda.base.presenter.Presenter;
import com.gideondev.safeboda.internal.di.component.DaggerProjectComponent;
import com.gideondev.safeboda.internal.di.module.ProjectModule;
import com.gideondev.safeboda.model.schedules.ScheduleItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class AirLIneListActivity extends BaseActionbarActivity implements AirlineListView,View.OnClickListener{
    @Inject
    AirlineListPresenter presenter;
    private RecyclerView recyclerView;
    private airlineListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniActionbar();
        initView();
        injectInjector();
        initModel();
    }

    @Override
    protected void injectInjector() {
        DaggerProjectComponent.builder()
                .projectModule(new ProjectModule(this))
                .build()
                .inject(this);
        presenter.setView(this);
        presenter.initData();
    }

    @Override
    public void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
    }

    private void iniActionbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("FlightSearch");
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void initModel() {

    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void notifyAdapter() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setUpAdapter(List<ScheduleItem> list) {
            mAdapter = new airlineListAdapter(getContext(),list,presenter);
            recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
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
