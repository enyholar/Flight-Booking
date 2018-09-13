package com.gideondev.safeboda.model.schedules;

import com.google.gson.annotations.SerializedName;

public class Details{

	@SerializedName("Stops")
	private Stops stops;

	@SerializedName("DaysOfOperation")
	private int daysOfOperation;

	@SerializedName("DatePeriod")
	private DatePeriod datePeriod;

	public void setStops(Stops stops){
		this.stops = stops;
	}

	public Stops getStops(){
		return stops;
	}

	public void setDaysOfOperation(int daysOfOperation){
		this.daysOfOperation = daysOfOperation;
	}

	public int getDaysOfOperation(){
		return daysOfOperation;
	}

	public void setDatePeriod(DatePeriod datePeriod){
		this.datePeriod = datePeriod;
	}

	public DatePeriod getDatePeriod(){
		return datePeriod;
	}

	@Override
 	public String toString(){
		return 
			"Details{" + 
			"stops = '" + stops + '\'' + 
			",daysOfOperation = '" + daysOfOperation + '\'' + 
			",datePeriod = '" + datePeriod + '\'' + 
			"}";
		}
}