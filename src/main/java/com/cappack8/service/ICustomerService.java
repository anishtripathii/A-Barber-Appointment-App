package com.cappack8.service;

import java.util.List;

import com.cappack8.exception.BarberIdNotFoundException;
import com.cappack8.exception.BookingCreationException;
import com.cappack8.exception.BookingIdNotFoundException;
import com.cappack8.exception.CustomerNotFoundException;
import com.cappack8.exception.ServiceNotFoundException;
import com.cappack8.model.Availability;
import com.cappack8.model.Barber;
import com.cappack8.model.Booking;
import com.cappack8.model.Services;

public interface ICustomerService {
	
	public List<Barber> viewAllBarbers();
	public List<Barber> viewBarbersBySortedRating();
	public List<Services> viewAllServiceOfBarber(int barberId) throws BarberIdNotFoundException;
	//public Booking bookAService(Booking booking);
	public Booking bookAService(Booking booking, int barbId, int custId, int serid, String stTime, String endTime, String dos,  Availability availa) throws BookingCreationException, BarberIdNotFoundException, ServiceNotFoundException;
	public int changeTheService(String newServiceName, int barberId, int serviceId) throws BarberIdNotFoundException;
	public int cancelOrder(int bookingId) throws BookingIdNotFoundException;
	public int giveFeedback(int barberId, int par1, int par2, int par3) throws BarberIdNotFoundException;
	public List<Booking> viewBookedOrders(int customerId) throws CustomerNotFoundException;
	public List<Booking> viewPreviousOrders(int customerId) throws CustomerNotFoundException;
	public List<String> getNameOfBarber(int barberId) throws BarberIdNotFoundException;
	public double getCostPerSessionbyid(int barberId) throws BarberIdNotFoundException;
	public double getCostofTheServiceatLast(int barberId, int serviceId) throws BarberIdNotFoundException, ServiceNotFoundException;
	

}
