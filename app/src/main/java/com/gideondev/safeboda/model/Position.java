package com.gideondev.safeboda.model;

import com.google.gson.annotations.SerializedName;

public class Position{

	@SerializedName("Coordinate")
	private Coordinate coordinate;

	public void setCoordinate(Coordinate coordinate){
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate(){
		return coordinate;
	}

	@Override
 	public String toString(){
		return 
			"Position{" + 
			"coordinate = '" + coordinate + '\'' + 
			"}";
		}
}