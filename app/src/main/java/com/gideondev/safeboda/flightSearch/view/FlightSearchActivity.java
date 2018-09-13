package com.gideondev.safeboda.flightSearch.view;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.gideondev.safeboda.R;
import com.gideondev.safeboda.base.BaseActionbarActivity;
import com.gideondev.safeboda.base.presenter.Presenter;
import com.gideondev.safeboda.flightSearch.presenter.presenter_view.FlightSearchPresenter;
import com.gideondev.safeboda.flightSearch.presenter.presenter_view.FlightSearchView;
import com.gideondev.safeboda.internal.di.component.DaggerProjectComponent;
import com.gideondev.safeboda.internal.di.module.ProjectModule;
import com.gideondev.safeboda.model.AirportItem;
import com.gideondev.safeboda.model.NameItem;
import com.gideondev.safeboda.model.cities.CityItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

public class FlightSearchActivity extends BaseActionbarActivity implements FlightSearchView {
    @Inject
    FlightSearchPresenter presenter;
    private Spinner originSpinner,destinationSpinner;
    Calendar myCalendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener date;
    private Button btnDepartureDate;
    private DatePickerDialog StartTime;

    @Override
    public void initView() {
        originSpinner = (Spinner) findViewById(R.id.origin_spinner);
        destinationSpinner = (Spinner) findViewById(R.id.destination_spinner);

       btnDepartureDate = findViewById(R.id.btnDepartureDatePicker);
        findViewById(R.id.btnDepartureDatePicker).setOnClickListener(this);
        findViewById(R.id.btnSearch).setOnClickListener(this);
        datePicker();

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightsearch);
        iniActionbar();
        initView();
        injectInjector();
    }

    @Override
    protected void injectInjector() {
        DaggerProjectComponent.builder()
                .projectModule(new ProjectModule(this))
                .build()
                .inject(this);
        presenter.setView(this);
        presenter.start();
        presenter.initData();
    }

    @Override
    public void showOriginDestinationSpinnerData(List<AirportItem> cityItemList) {
        ArrayAdapter<AirportItem> dataAdapter = new ArrayAdapter<AirportItem>(this,
                android.R.layout.simple_spinner_item, cityItemList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        originSpinner.setAdapter(dataAdapter);
        originSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AirportItem model = (AirportItem) parent.getItemAtPosition(position);
                presenter.getOriginCityModel(model);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dataAdapter.notifyDataSetChanged();


        ArrayAdapter<AirportItem> destinationAdapter = new ArrayAdapter<AirportItem>(this,
                android.R.layout.simple_spinner_item, cityItemList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationSpinner.setAdapter(dataAdapter);
        destinationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AirportItem model = (AirportItem) parent.getItemAtPosition(position);
                presenter.getDestinationCityModel(model);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        destinationAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDepartureDatePicker:
           new DatePickerDialog(FlightSearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

                break;

            case R.id.btnSearch:
                presenter.searchForFlight();
                break;
        }

        super.onClick(v);
    }

    private void datePicker(){
      date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                presenter.getDate(myCalendar
                        .get(Calendar.DAY_OF_MONTH),myCalendar
                        .get(Calendar.MONTH),myCalendar
                        .get(Calendar.YEAR));

                String dateFormat = presenter.getDate(myCalendar
                        .get(Calendar.DAY_OF_MONTH),myCalendar
                        .get(Calendar.MONTH),myCalendar
                        .get(Calendar.YEAR));
                btnDepartureDate.setText(dateFormat);
            }

        };
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
