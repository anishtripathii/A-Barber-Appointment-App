package com.cappack8.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name="BarberTimeSlots")
public class TimeSlots {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int timeId;
	
	private String days;
	
	@NotNull
    @Size(max = 100)
	private String startTime;
	
	@NotNull
    @Size(max = 100)
	private String endTime;
	
	private String status;

	public int getTimeId() {
		return timeId;
	}

	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
