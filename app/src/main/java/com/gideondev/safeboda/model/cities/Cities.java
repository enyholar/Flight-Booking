package com.gideondev.safeboda.model.cities;

import java.util.List;
import com.google.gson.annotations.SerializedName;
public class Cities{

	@SerializedName("City")
	private List<CityItem> city;

	public void setCity(List<CityItem> city){
		this.city = city;
	}

	public List<CityItem> getCity(){
		return city;
	}

	@Override
 	public String toString(){
		return 
			"Cities{" + 
			"city = '" + city + '\'' + 
			"}";
		}
}