package com.gideondev.safeboda.model.cities;


import com.google.gson.annotations.SerializedName;

public class NameItem {

	@SerializedName("@LanguageCode")
	private String languageCode;

	@SerializedName("$")
	private String en;

	public void setLanguageCode(String languageCode){
		this.languageCode = languageCode;
	}

	public String getLanguageCode(){
		return languageCode;
	}

	public void set(String en){
		this.en = en;
	}

	public String get(){
		return en ;
	}

	@Override
 	public String toString(){
		return 
			"NameItem{" + 
			"@LanguageCode = '" + languageCode + '\'' + 
			",$ = '" +  + '\'' + 
			"}";
		}
}