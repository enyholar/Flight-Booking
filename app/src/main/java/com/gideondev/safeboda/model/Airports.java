package com.gideondev.safeboda.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Airports{

	@SerializedName("Airport")
	private List<AirportItem> airport;

	public void setAirport(List<AirportItem> airport){
		this.airport = airport;
	}

	public List<AirportItem> getAirport(){
		return airport;
	}

	@Override
 	public String toString(){
		return 
			"Airports{" + 
			"airport = '" + airport + '\'' + 
			"}";
		}
}