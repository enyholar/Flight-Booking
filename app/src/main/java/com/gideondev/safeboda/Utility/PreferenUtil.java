package com.gideondev.safeboda.Utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import android.preference.PreferenceManager;

import com.gideondev.safeboda.model.AirportItem;
import com.google.gson.Gson;



public class PreferenUtil {


  public static final String SKIP_REGISTRATION_KEY = "SKIPREGISTRATIONKEY";
  public static final String DEPARTURE_KEY = "departureKey";
  public static final String ARRIVAL_KEY = "arrivalKey";
  public static final String ACCESSTOKEN = "access_token";
  private static Context mContext;
  @SuppressLint("StaticFieldLeak")
  private static PreferenUtil mInstant = null;

  private PreferenUtil(Context context) {
    mContext = context;
  }

  public static PreferenUtil getInstant(Context context) {
    if (mInstant == null) {
      mInstant = new PreferenUtil(context);
      PreferenceManager.getDefaultSharedPreferences(context)
          .registerOnSharedPreferenceChangeListener(mListener);
    }
    return mInstant;
  }


  private static SharedPreferences.OnSharedPreferenceChangeListener mListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
  };



  public void saveDepartureItem(AirportItem airportItem) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
    Gson gson = new Gson();
    String json = gson.toJson(airportItem);
    sharedPreferencesEditor.putString(DEPARTURE_KEY, json);
    sharedPreferencesEditor.apply();
  }

  public void saveAccessToken(String token) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
    sharedPreferencesEditor.putString(ACCESSTOKEN, token);
    sharedPreferencesEditor.apply();
  }

  public String  getAccessToken() {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    return  sharedPreferences.getString(ACCESSTOKEN, "");
  }

  public AirportItem getDepartureItem() {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    Gson gson = new Gson();
    String json = sharedPreferences.getString(DEPARTURE_KEY, "");
    return gson.fromJson(json, AirportItem.class);
  }


  public void saveArrivalItem(AirportItem airportItem) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
    Gson gson = new Gson();
    String json = gson.toJson(airportItem);
    sharedPreferencesEditor.putString(ARRIVAL_KEY, json);
    sharedPreferencesEditor.apply();
  }


  public AirportItem getArrivalItem() {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    Gson gson = new Gson();
    String json = sharedPreferences.getString(ARRIVAL_KEY, "");
    return gson.fromJson(json, AirportItem.class);
  }

}
