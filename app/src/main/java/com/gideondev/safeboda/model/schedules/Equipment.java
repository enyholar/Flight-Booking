package com.gideondev.safeboda.model.schedules;
import com.google.gson.annotations.SerializedName;
public class Equipment{

	@SerializedName("AircraftCode")
	private String aircraftCode;

	public void setAircraftCode(String aircraftCode){
		this.aircraftCode = aircraftCode;
	}

	public String getAircraftCode(){
		return aircraftCode;
	}

	@Override
 	public String toString(){
		return 
			"Equipment{" + 
			"aircraftCode = '" + aircraftCode + '\'' + 
			"}";
		}
}