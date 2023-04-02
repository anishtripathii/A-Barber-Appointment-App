package com.cappack8.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cappack8.model.Availability;
import com.cappack8.model.TimeSlots;
import com.cappack8.repository.TimeSlotRepository;
import com.cappack8.service.ITimeSlots;

@Service
public class TimeSlotDao implements ITimeSlots{
	
	@Autowired
	TimeSlotRepository tRepo;
	
	@Override
	public TimeSlots addTimeSlots(TimeSlots slot) {
		return tRepo.save(slot);
		
	}
	
	@Override
	public List<TimeSlots> viewAllSlots(){
		return tRepo.findAll();
	}
	
	@Override
	public int updateStatusofTimeSlots(int timeId, String avail) {
		return tRepo.updatingStatusOfBarber(timeId, avail);
	}

}
