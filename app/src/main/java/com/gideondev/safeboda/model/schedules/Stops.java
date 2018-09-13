package com.gideondev.safeboda.model.schedules;

import com.google.gson.annotations.SerializedName;

public class Stops{

	@SerializedName("StopQuantity")
	private int stopQuantity;

	public void setStopQuantity(int stopQuantity){
		this.stopQuantity = stopQuantity;
	}

	public int getStopQuantity(){
		return stopQuantity;
	}

	@Override
 	public String toString(){
		return 
			"Stops{" + 
			"stopQuantity = '" + stopQuantity + '\'' + 
			"}";
		}
}