package com.gideondev.safeboda.model.cities;

import com.google.gson.annotations.SerializedName;

public class CityResource{

	@SerializedName("Meta")
	private Meta meta;

	@SerializedName("Cities")
	private Cities cities;

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setCities(Cities cities){
		this.cities = cities;
	}

	public Cities getCities(){
		return cities;
	}

	@Override
 	public String toString(){
		return 
			"CityResource{" + 
			"meta = '" + meta + '\'' + 
			",cities = '" + cities + '\'' + 
			"}";
		}
}