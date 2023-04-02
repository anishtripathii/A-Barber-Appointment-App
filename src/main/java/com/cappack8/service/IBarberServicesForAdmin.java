package com.cappack8.service;

import java.util.List;


import com.cappack8.exception.BarberCreationException;
import com.cappack8.exception.BarberIdNotFoundException;
import com.cappack8.exception.ServiceCreationException;
import com.cappack8.exception.TimeSlotCreationException;
import com.cappack8.model.Barber;
//import com.cappack8.model.Customer;
import com.cappack8.model.Services;
import com.cappack8.model.TimeSlots;



public interface IBarberServicesForAdmin {
	
	public Barber addBarber(Barber barber) throws BarberCreationException;
	public Services addService(Services service) throws ServiceCreationException;
	//public Services updatingService(int serviceId, double cost);
	public int updatingCostOfBarber(int barberid, double cost) throws BarberIdNotFoundException;
	public List<Barber> viewBarbersBySortedRating();
	public List<Barber> viewAllBarbers();
	//public List<Customer> viewCustomersInSortedRating();
	public List<Services> viewServicesofBarber(int barberId) throws BarberIdNotFoundException;
	public List<TimeSlots> viewTimeSlotsofBarber(int barberId) throws BarberIdNotFoundException;
}

