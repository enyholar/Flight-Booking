package com.gideondev.safeboda.model.schedules;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("@Version")
	private String version;

	@SerializedName("Link")
	private List<LinkItem> link;

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
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
			",link = '" + link + '\'' + 
			"}";
		}
}