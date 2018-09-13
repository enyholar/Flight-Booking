package com.gideondev.safeboda.model.cities;

import com.google.gson.annotations.SerializedName;

public class CityItem{

	@SerializedName("CityCode")
	private String cityCode;

	@SerializedName("Names")
	private Names names;

	@SerializedName("Position")
	private Position position;

	@SerializedName("CountryCode")
	private String countryCode;

	@SerializedName("Airports")
	private Airports airports;

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

	public void setPosition(Position position){
		this.position = position;
	}

	public Position getPosition(){
		return position;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setAirports(Airports airports){
		this.airports = airports;
	}

	public Airports getAirports(){
		return airports;
	}

//	@Override
// 	public String toString(){
//		return
//			"CityItem{" +
//			"cityCode = '" + cityCode + '\'' +
//			",names = '" + names + '\'' +
//			",position = '" + position + '\'' +
//			",countryCode = '" + countryCode + '\'' +
//			",airports = '" + airports + '\'' +
//			"}";
//		}


	@Override
	public String toString(){
		return cityCode;
	}
}