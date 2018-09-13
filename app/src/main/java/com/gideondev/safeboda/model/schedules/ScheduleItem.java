package com.gideondev.safeboda.model.schedules;

import java.util.List;
import com.google.gson.annotations.SerializedName;
public class ScheduleItem{

	@SerializedName("Flight")
	private List<FlightItem> flight;

	@SerializedName("TotalJourney")
	private TotalJourney totalJourney;

	public void setFlight(List<FlightItem> flight){
		this.flight = flight;
	}

	public List<FlightItem> getFlight(){
		return flight;
	}

	public void setTotalJourney(TotalJourney totalJourney){
		this.totalJourney = totalJourney;
	}

	public TotalJourney getTotalJourney(){
		return totalJourney;
	}

	@Override
 	public String toString(){
		return 
			"ScheduleItem{" + 
			"flight = '" + flight + '\'' + 
			",totalJourney = '" + totalJourney + '\'' + 
			"}";
		}
}