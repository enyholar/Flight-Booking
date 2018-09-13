package com.gideondev.safeboda.model.schedules;
import com.google.gson.annotations.SerializedName;

public class Terminal{

	@SerializedName("Name")
	private String name;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Terminal{" + 
			"name = '" + name + '\'' + 
			"}";
		}
}