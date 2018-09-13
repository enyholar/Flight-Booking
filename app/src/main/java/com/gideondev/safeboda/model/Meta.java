package com.gideondev.safeboda.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Meta{

	@SerializedName("@Version")
	private String version;

	@SerializedName("TotalCount")
	private int totalCount;

	@SerializedName("Link")
	private List<LinkItem> link;

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}

	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}

	public int getTotalCount(){
		return totalCount;
	}

	public void setLink(List<LinkItem> link){
		this.link = link;
	}

	public List<LinkItem> getLink(){
		return link;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"@Version = '" + version + '\'' + 
			",totalCount = '" + totalCount + '\'' + 
			",link = '" + link + '\'' + 
			"}";
		}
}