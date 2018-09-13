package com.gideondev.safeboda.model.schedules;
import com.google.gson.annotations.SerializedName;

public class ScheduleResponse{

	@SerializedName("ScheduleResource")
	private ScheduleResource scheduleResource;

	public void setScheduleResource(ScheduleResource scheduleResource){
		this.scheduleResource = scheduleResource;
	}

	public ScheduleResource getScheduleResource(){
		return scheduleResource;
	}

	@Override
 	public String toString(){
		return 
			"ScheduleResponse{" + 
			"scheduleResource = '" + scheduleResource + '\'' + 
			"}";
		}
}