package com.gideondev.safeboda.model.schedules;
import com.google.gson.annotations.SerializedName;

public class ScheduledTimeLocal{

	@SerializedName("DateTime")
	private String dateTime;

	public void setDateTime(String dateTime){
		this.dateTime = dateTime;
	}

	public String getDateTime(){
		return dateTime;
	}

	@Override
 	public String toString(){
		return 
			"ScheduledTimeLocal{" + 
			"dateTime = '" + dateTime + '\'' + 
			"}";
		}
}