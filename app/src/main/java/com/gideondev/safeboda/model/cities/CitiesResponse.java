package com.gideondev.safeboda.model.cities;

import com.google.gson.annotations.SerializedName;

public class CitiesResponse{

	@SerializedName("CityResource")
	private CityResource cityResource;

	public void setCityResource(CityResource cityResource){
		this.cityResource = cityResource;
	}

	public CityResource getCityResource(){
		return cityResource;
	}

	@Override
 	public String toString(){
		return 
			"CitiesResponse{" + 
			"cityResource = '" + cityResource + '\'' + 
			"}";
		}
}