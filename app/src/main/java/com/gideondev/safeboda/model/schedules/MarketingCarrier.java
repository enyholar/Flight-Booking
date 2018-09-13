package com.gideondev.safeboda.model.schedules;

import com.google.gson.annotations.SerializedName;

public class MarketingCarrier{

	@SerializedName("AirlineID")
	private String airlineID;

	@SerializedName("FlightNumber")
	private int flightNumber;

	public void setAirlineID(String airlineID){
		this.airlineID = airlineID;
	}

	public String getAirlineID(){
		return airlineID;
	}

	public void setFlightNumber(int flightNumber){
		this.flightNumber = flightNumber;
	}

	public int getFlightNumber(){
		return flightNumber;
	}

	@Override
 	public String toString(){
		return 
			"MarketingCarrier{" + 
			"airlineID = '" + airlineID + '\'' + 
			",flightNumber = '" + flightNumber + '\'' + 
			"}";
		}
}