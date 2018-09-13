package com.gideondev.safeboda.model.schedules;

import com.google.gson.annotations.SerializedName;

public class LinkItem{

	@SerializedName("@Href")
	private String href;

	@SerializedName("@Rel")
	private String rel;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	public void setRel(String rel){
		this.rel = rel;
	}

	public String getRel(){
		return rel;
	}

	@Override
 	public String toString(){
		return 
			"LinkItem{" + 
			"@Href = '" + href + '\'' + 
			",@Rel = '" + rel + '\'' + 
			"}";
		}
}