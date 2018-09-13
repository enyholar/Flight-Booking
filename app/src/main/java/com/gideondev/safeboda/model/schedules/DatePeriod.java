package com.gideondev.safeboda.model.schedules;

import com.google.gson.annotations.SerializedName;

public class DatePeriod{

	@SerializedName("Expiration")
	private String expiration;

	@SerializedName("Effective")
	private String effective;

	public void setExpiration(String expiration){
		this.expiration = expiration;
	}

	public String getExpiration(){
		return expiration;
	}

	public void setEffective(String effective){
		this.effective = effective;
	}

	public String getEffective(){
		return effective;
	}

	@Override
 	public String toString(){
		return 
			"DatePeriod{" + 
			"expiration = '" + expiration + '\'' + 
			",effective = '" + effective + '\'' + 
			"}";
		}
}