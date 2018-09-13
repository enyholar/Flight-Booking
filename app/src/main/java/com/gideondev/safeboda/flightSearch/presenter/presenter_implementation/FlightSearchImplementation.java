package com.gideondev.safeboda.flightSearch.presenter.presenter_implementation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.gideondev.safeboda.Utility.PreferenUtil;
import com.gideondev.safeboda.Utility.ProgressBarHandler;
import com.gideondev.safeboda.availableFlights.View.AirLIneListActivity;
import com.gideondev.safeboda.flightSearch.presenter.presenter_view.FlightSearchPresenter;
import com.gideondev.safeboda.flightSearch.presenter.presenter_view.FlightSearchView;
import com.gideondev.safeboda.model.AirportItem;
import com.gideondev.safeboda.model.AirportResource;
import com.gideondev.safeboda.model.AirportResponse;
import com.gideondev.safeboda.model.Token;
import com.gideondev.safeboda.model.schedules.ScheduleResponse;
import com.gideondev.safeboda.retrofit.FlightLocationClient;
import com.gideondev.safeboda.retrofit.webservice;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.gideondev.safeboda.Utility.Constant.KEY_SCHEDULE_LIST;

public class FlightSearchImplementation implements FlightSearchPresenter {
    private FlightSearchView mView;
    private AirportItem destinationAirport;
    private AirportItem originAirport;
    private String departureDate;
    private PreferenUtil preferenUtil;
    private ProgressBarHandler progressBarHandler;

    @Override
    public void initData() {
        webservice apiServices =
                FlightLocationClient.getClient().create(webservice.class);

        if (preferenUtil.getAccessToken() != null && !preferenUtil.getAccessToken().isEmpty()){
            Call<AirportResponse> jsonAirport = apiServices.getAllAirport("Bearer "+ preferenUtil.getAccessToken(), "application/json");
            jsonAirport.enqueue(new Callback<AirportResponse>() {
                @Override
                public void onResponse(Call<AirportResponse> call, Response<AirportResponse> response) {
                    Log.i("solved", "");
                    if (response != null) {
                        if (response.message().equals("Unauthorized")) {
                            getTokenFromService();
                        } else if (response.body() != null) {
                            AirportResource airportResource = response.body().getAirportResource();
                            mView.showOriginDestinationSpinnerData(airportResource.getAirports().getAirport());
                        }

                    }
                }

                @Override
                public void onFailure (Call < AirportResponse > call, Throwable t){
                    Log.i("error", t.toString());
                }
            });
        }else {
            getTokenFromService();
        }



}

    @Override
    public void start() {
        preferenUtil = PreferenUtil.getInstant(mView.getContext());
        progressBarHandler = new ProgressBarHandler(mView.getContext());
    }



    @Override
    public AirportItem getOriginCityModel(AirportItem originCities) {
        originAirport = originCities;
        return originAirport;
    }

    @Override
    public AirportItem getDestinationCityModel(AirportItem destinationCities) {
        destinationAirport = destinationCities;
        return destinationAirport;
    }

    @Override
    public String getDate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        departureDate = sdf.format(calendar.getTime());
        return departureDate;
    }


    @Override
    public void searchForFlight() {
        if (destinationAirport != null && originAirport != null) {
            progressBarHandler.show();
            String destinationIATA = destinationAirport.getAirportCode();
            String originIATA = originAirport.getAirportCode();

            webservice apiServices =
                    FlightLocationClient.getClient().create(webservice.class);
            Call<ScheduleResponse> jsonFlight = apiServices.getAllFlight("Bearer " + preferenUtil.getAccessToken(),
                    "application/json", originIATA, destinationIATA, departureDate, false);
            jsonFlight.enqueue(new Callback<ScheduleResponse>() {
                @Override
                public void onResponse(Call<ScheduleResponse> call, Response<ScheduleResponse> response) {
                    Toast.makeText(mView.getContext(), response.message(), Toast.LENGTH_LONG).show();
                    if (response.body() != null && response.body().getScheduleResource() != null) {
                        if (destinationAirport != null && originAirport != null) {
                            preferenUtil.saveArrivalItem(destinationAirport);
                            preferenUtil.saveDepartureItem(originAirport);
                        }
                        Intent intent = new Intent(mView.getActivity(), AirLIneListActivity.class);
                        Gson gson = new Gson();
                        String json = gson.toJson(response.body().getScheduleResource());
                        intent.putExtra(KEY_SCHEDULE_LIST, json);
                        mView.getActivity().startActivity(intent);

                    }
                    progressBarHandler.hide();
                }

                @Override
                public void onFailure(Call<ScheduleResponse> call, Throwable t) {
                    Log.i("error", t.toString());
                    Toast.makeText(mView.getContext(), t.toString(), Toast.LENGTH_LONG).show();
                    progressBarHandler.hide();
                }
            });
        }
    }

        @Override
        public void getTokenFromService() {
            webservice apiServic =
                    FlightLocationClient.getClient().create(webservice.class);
            Call<Token> jsonToken = apiServic.requestToken("pbrqs6yz9pkx76pgane9p4f4", "Uf879768fY", "client_credentials");
            jsonToken.enqueue(new Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {
                    if (response.body() != null && !response.body().getAccessToken().isEmpty()) {
                        preferenUtil.saveAccessToken(response.body().getAccessToken());
                        initData();
                        Log.i("solved", response.body().toString());
                    }

                }

                @Override
                public void onFailure(Call<Token> call, Throwable t) {
                    Log.i("error", t.toString());
                }
            });
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
    public void setView(@NonNull FlightSearchView view) {
        this.mView = view;
    }
}
