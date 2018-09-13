package com.gideondev.safeboda.model.schedules;

import com.google.gson.annotations.SerializedName;

public class FlightItem{

	@SerializedName("Details")
	private Details details;

	@SerializedName("Equipment")
	private Equipment equipment;

	@SerializedName("Departure")
	private Departure departure;

	@SerializedName("MarketingCarrier")
	private MarketingCarrier marketingCarrier;

	@SerializedName("Arrival")
	private Arrival arrival;

	@SerializedName("OperatingCarrier")
	private OperatingCarrier operatingCarrier;

	public void setDetails(Details details){
		this.details = details;
	}

	public Details getDetails(){
		return details;
	}

	public void setEquipment(Equipment equipment){
		this.equipment = equipment;
	}

	public Equipment getEquipment(){
		return equipment;
	}

	public void setDeparture(Departure departure){
		this.departure = departure;
	}

	public Departure getDeparture(){
		return departure;
	}

	public void setMarketingCarrier(MarketingCarrier marketingCarrier){
		this.marketingCarrier = marketingCarrier;
	}

	public MarketingCarrier getMarketingCarrier(){
		return marketingCarrier;
	}

	public void setArrival(Arrival arrival){
		this.arrival = arrival;
	}

	public Arrival getArrival(){
		return arrival;
	}

	public void setOperatingCarrier(OperatingCarrier operatingCarrier){
		this.operatingCarrier = operatingCarrier;
	}

	public OperatingCarrier getOperatingCarrier(){
		return operatingCarrier;
	}

	@Override
 	public String toString(){
		return 
			"FlightItem{" + 
			"details = '" + details + '\'' + 
			",equipment = '" + equipment + '\'' + 
			",departure = '" + departure + '\'' + 
			",marketingCarrier = '" + marketingCarrier + '\'' + 
			",arrival = '" + arrival + '\'' + 
			",operatingCarrier = '" + operatingCarrier + '\'' + 
			"}";
		}
}