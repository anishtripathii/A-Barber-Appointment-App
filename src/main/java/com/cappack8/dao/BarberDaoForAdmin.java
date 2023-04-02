package com.cappack8.dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cappack8.controller.AdminController;
import com.cappack8.exception.BarberCreationException;
import com.cappack8.exception.BarberIdNotFoundException;
import com.cappack8.exception.ServiceCreationException;
import com.cappack8.model.Barber;
import com.cappack8.model.Services;
import com.cappack8.model.TimeSlots;
import com.cappack8.repository.BarberRepository;
import com.cappack8.repository.ServiceRepository;
import com.cappack8.service.IBarberServicesForAdmin;

@Service
public class BarberDaoForAdmin implements IBarberServicesForAdmin{
	
	
	@Autowired
	BarberRepository barRepos;
	
	@Autowired
	ServiceRepository serRepos;
	
	@Autowired
	AdminController adao1;
	
	
	@Override
	public Barber addBarber(Barber barber) throws BarberCreationException {
		
		if(barRepos.existsById(barber.getBarberId())) {
			throw new BarberCreationException("Barber with the same Id already Exists");
		}
		
		return barRepos.save(barber);
		
	}

	@Override
	public Services addService(Services service) throws ServiceCreationException{
		
		if(serRepos.existsById(service.getServiceId())) {
			throw new ServiceCreationException("Service with the same Id is available");
		}
		return serRepos.save(service);
	}

	@Override
	public int updatingCostOfBarber(int barberid, double cost) throws BarberIdNotFoundException{
		
		if(barRepos.existsById(barberid) != true) {
			throw new BarberIdNotFoundException("Barber with this Id is not found, cannot update the cost");
			
		}
		return barRepos.updatingcostOfBarber(barberid, cost);
	}

	@Override
	public List<Barber> viewBarbersBySortedRating() {
		Sort sort = Sort.by("ratings").descending();
		return (List<Barber>) barRepos.findAll(sort);
	}

	@Override
	public List<Barber> viewAllBarbers() {
		return barRepos.findAll();
	}

	@Override
	public List<Services> viewServicesofBarber(int barberId) throws BarberIdNotFoundException{
		
		if(barRepos.existsById(barberId) != true) {
			throw new BarberIdNotFoundException("Barber with this Id is not found, cannot view services");
			
		}
		return barRepos.viewServicesOfBarber(barberId);
	}

	@Override
	public List<TimeSlots> viewTimeSlotsofBarber(int barberId) throws BarberIdNotFoundException{
		
		if(barRepos.existsById(barberId) != true) {
			throw new BarberIdNotFoundException("Barber with this Id is not found, cannot view the slots");
			
		}
		return barRepos.viewTimeSlotsOfBarber(barberId);
	}
	
	
	

}
