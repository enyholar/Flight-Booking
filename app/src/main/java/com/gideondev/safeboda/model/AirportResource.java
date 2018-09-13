package com.gideondev.safeboda.model;

import com.google.gson.annotations.SerializedName;

public class AirportResource{

	@SerializedName("Meta")
	private Meta meta;

	@SerializedName("Airports")
	private Airports airports;

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setAirports(Airports airports){
		this.airports = airports;
	}

	public Airports getAirports(){
		return airports;
	}

	@Override
 	public String toString(){
		return 
			"AirportResource{" + 
			"meta = '" + meta + '\'' + 
			",airports = '" + airports + '\'' + 
			"}";
		}
}