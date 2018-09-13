package com.gideondev.safeboda.model.cities;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Names{

	@SerializedName("Name")
	private List<NameItem> name;

	public void setName(List<NameItem> name){
		this.name = name;
	}

	public List<NameItem> getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Names{" + 
			"name = '" + name + '\'' + 
			"}";
		}
}