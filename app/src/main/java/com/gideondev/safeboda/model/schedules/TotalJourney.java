package com.gideondev.safeboda.model.schedules;
import com.google.gson.annotations.SerializedName;

public class TotalJourney{

	@SerializedName("Duration")
	private String duration;

	public void setDuration(String duration){
		this.duration = duration;
	}

	public String getDuration(){
		return duration;
	}

	@Override
 	public String toString(){
		return 
			"TotalJourney{" + 
			"duration = '" + duration + '\'' + 
			"}";
		}
}