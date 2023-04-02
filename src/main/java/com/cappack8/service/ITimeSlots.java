package com.cappack8.service;

import java.util.List;

import com.cappack8.model.Availability;
import com.cappack8.model.TimeSlots;

public interface ITimeSlots {
	
	public TimeSlots addTimeSlots(TimeSlots slot);
	public List<TimeSlots> viewAllSlots();
	public int updateStatusofTimeSlots(int timeId, String avail) ;

}
