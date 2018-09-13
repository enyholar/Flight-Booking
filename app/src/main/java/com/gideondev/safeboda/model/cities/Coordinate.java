package com.gideondev.safeboda.model.cities;

import com.google.gson.annotations.SerializedName;

public class Coordinate{

	@SerializedName("Latitude")
	private double latitude;

	@SerializedName("Longitude")
	private double longitude;

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"Coordinate{" + 
			"latitude = '" + latitude + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}