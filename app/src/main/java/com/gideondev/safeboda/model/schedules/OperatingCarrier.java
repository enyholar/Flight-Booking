package com.gideondev.safeboda.model.schedules;

import com.google.gson.annotations.SerializedName;

public class OperatingCarrier{

	@SerializedName("AirlineID")
	private String airlineID;

	public void setAirlineID(String airlineID){
		this.airlineID = airlineID;
	}

	public String getAirlineID(){
		return airlineID;
	}

	@Override
 	public String toString(){
		return 
			"OperatingCarrier{" + 
			"airlineID = '" + airlineID + '\'' + 
			"}";
		}
}