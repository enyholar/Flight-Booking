package com.gideondev.safeboda.model;

import com.google.gson.annotations.SerializedName;

public class AirportItem{

	@SerializedName("CityCode")
	private String cityCode;

	@SerializedName("Names")
	private Names names;

	@SerializedName("UtcOffset")
	private double utcOffset;

	@SerializedName("AirportCode")
	private String airportCode;

	@SerializedName("Position")
	private Position position;

	@SerializedName("TimeZoneId")
	private String timeZoneId;

	@SerializedName("CountryCode")
	private String countryCode;

	@SerializedName("LocationType")
	private String locationType;

	public void setCityCode(String cityCode){
		this.cityCode = cityCode;
	}

	public String getCityCode(){
		return cityCode;
	}

	public void setNames(Names names){
		this.names = names;
	}

	public Names getNames(){
		return names;
	}

	public void setUtcOffset(int utcOffset){
		this.utcOffset = utcOffset;
	}

	public double getUtcOffset(){
		return utcOffset;
	}

	public void setAirportCode(String airportCode){
		this.airportCode = airportCode;
	}

	public String getAirportCode(){
		return airportCode;
	}

	public void setPosition(Position position){
		this.position = position;
	}

	public Position getPosition(){
		return position;
	}

	public void setTimeZoneId(String timeZoneId){
		this.timeZoneId = timeZoneId;
	}

	public String getTimeZoneId(){
		return timeZoneId;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setLocationType(String locationType){
		this.locationType = locationType;
	}

	public String getLocationType(){
		return locationType;
	}

//	@Override
// 	public String toString(){
//		return
//			"AirportItem{" +
//			"cityCode = '" + cityCode + '\'' +
//			",names = '" + names + '\'' +
//			",utcOffset = '" + utcOffset + '\'' +
//			",airportCode = '" + airportCode + '\'' +
//			",position = '" + position + '\'' +
//			",timeZoneId = '" + timeZoneId + '\'' +
//			",countryCode = '" + countryCode + '\'' +
//			",locationType = '" + locationType + '\'' +
//			"}";
//		}


    @Override
    public String toString(){
        return airportCode +"" + "(" + countryCode+ ")";
    }
}