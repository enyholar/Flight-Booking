package com.gideondev.safeboda.model.schedules;

import com.google.gson.annotations.SerializedName;
public class Arrival{

	@SerializedName("AirportCode")
	private String airportCode;

	@SerializedName("ScheduledTimeLocal")
	private ScheduledTimeLocal scheduledTimeLocal;

	@SerializedName("Terminal")
	private Terminal terminal;

	public void setAirportCode(String airportCode){
		this.airportCode = airportCode;
	}

	public String getAirportCode(){
		return airportCode;
	}

	public void setScheduledTimeLocal(ScheduledTimeLocal scheduledTimeLocal){
		this.scheduledTimeLocal = scheduledTimeLocal;
	}

	public ScheduledTimeLocal getScheduledTimeLocal(){
		return scheduledTimeLocal;
	}

	public void setTerminal(Terminal terminal){
		this.terminal = terminal;
	}

	public Terminal getTerminal(){
		return terminal;
	}

	@Override
 	public String toString(){
		return 
			"Arrival{" + 
			"airportCode = '" + airportCode + '\'' + 
			",scheduledTimeLocal = '" + scheduledTimeLocal + '\'' + 
			",terminal = '" + terminal + '\'' + 
			"}";
		}
}