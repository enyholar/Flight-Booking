package com.gideondev.safeboda.model.cities;

import com.google.gson.annotations.SerializedName;
public class Airports{

	@SerializedName("AirportCode")
	private String airportCode;

	public void setAirportCode(String airportCode){
		this.airportCode = airportCode;
	}

	public String getAirportCode(){
		return airportCode;
	}

	@Override
 	public String toString(){
		return 
			"Airports{" + 
			"airportCode = '" + airportCode + '\'' + 
			"}";
		}
}