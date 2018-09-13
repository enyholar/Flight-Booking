package com.gideondev.safeboda.model;

import com.google.gson.annotations.SerializedName;

public class AirportResponse {

	@SerializedName("AirportResource")
	private AirportResource airportResource;

	public void setAirportResource(AirportResource airportResource){
		this.airportResource = airportResource;
	}

	public AirportResource getAirportResource(){
		return airportResource;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"airportResource = '" + airportResource + '\'' + 
			"}";
		}
}