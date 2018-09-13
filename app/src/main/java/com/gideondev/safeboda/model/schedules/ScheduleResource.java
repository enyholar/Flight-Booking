package com.gideondev.safeboda.model.schedules;

import java.util.List;
import com.google.gson.annotations.SerializedName;
public class ScheduleResource{

	@SerializedName("Meta")
	private Meta meta;

	@SerializedName("Schedule")
	private List<ScheduleItem> schedule;

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setSchedule(List<ScheduleItem> schedule){
		this.schedule = schedule;
	}

	public List<ScheduleItem> getSchedule(){
		return schedule;
	}

	@Override
 	public String toString(){
		return 
			"ScheduleResource{" + 
			"meta = '" + meta + '\'' + 
			",schedule = '" + schedule + '\'' + 
			"}";
		}
}