package com.cappack8.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cappack8.repository.BarberRepository;
import com.cappack8.repository.BookingRepository;
import com.cappack8.repository.CustomerRepository;
import com.cappack8.repository.ServiceRepository;
import com.cappack8.model.Customer;
import com.cappack8.exception.BarberIdNotFoundException;
import com.cappack8.exception.BookingCreationException;
import com.cappack8.exception.BookingIdNotFoundException;
import com.cappack8.exception.CustomerNotFoundException;
import com.cappack8.exception.ServiceNotFoundException;
import com.cappack8.model.Availability;
import com.cappack8.model.Barber;
import com.cappack8.model.Booking;
import com.cappack8.model.Services;
import com.cappack8.service.ICustomerService;

@Service
public class BarberDaoForCustomer implements ICustomerService
{
	
	@Autowired
	CustomerRepository cusRepos;
	
	@Autowired
	BarberRepository barRepos;
	
	@Autowired
	ServiceRepository serRepos;
	
	@Autowired 
	BookingRepository bookRepos;
	
	@Override
	public List<Barber> viewAllBarbers() {
		return (List<Barber>)barRepos.findAll();
	}

	@Override
	public List<Barber> viewBarbersBySortedRating() {
		Sort sort = Sort.by("ratings");
		return (List<Barber>) barRepos.findAll(sort);
	}

	@Override
	public List<Services> viewAllServiceOfBarber(int barberId) throws BarberIdNotFoundException{
		
		if(barRepos.existsById(barberId) != true) {
			throw new BarberIdNotFoundException("There are no provied services with that particular Id");
		}
		return barRepos.viewServicesOfBarber(barberId);
	}

	@Override
	public Booking bookAService(Booking booking, int barbId, int custId, int serid, String stTime, String endTime, String dos,  Availability availa) throws BookingCreationException, BarberIdNotFoundException, ServiceNotFoundException{
		if(barRepos.existsById(barbId) != true ) {
			throw new BookingCreationException("Barber with that Id is not found, cannot Book an Order");
		}
		else if(serRepos.existsById(serid) != true) {
			throw new BookingCreationException("Service with that Id is not found, cannot provide the service");
		}
		else {
			
			booking.setBarberId(barbId);
			booking.setCid(custId);
			booking.setServiceid(serid);
			booking.setStartTime(stTime);
			booking.setEndTime(endTime);
			booking.setDateofService(dos);
			booking.setAvailable(availa);
			LocalDate date = LocalDate.now();
			booking.setDateofBooking(date);
			List<String> bName = getNameOfBarber(barbId);
			String Bname = String.join(" ", bName);
			booking.setBarberName(Bname);
			booking.setServiceName(serRepos.getNameofServiceByid(serid));
			booking.setCostatLast(getCostofTheServiceatLast(barbId,serid));
			Customer c = cusRepos.getById(custId);
			c.getBookings().add(booking);
			
		}
		
		return bookRepos.save(booking);
	}

	@Override
	public int changeTheService(String newServiceName, int bookingId, int serviceId) throws BarberIdNotFoundException{
		int status = 0;
		if(bookRepos.existsById(bookingId)) {
			status = bookRepos.changeTheServicebyName(newServiceName, bookingId, serviceId );
		}
		else {
			throw new BarberIdNotFoundException("Booking with that Id not found, cannot Update the service");
		}
		return status;
	}

	@Override
	public int cancelOrder(int bookingId) throws BookingIdNotFoundException{
		int status = 0;
		if(bookRepos.existsById(bookingId)) {
			bookRepos.deletethecascade(bookingId);
			 bookRepos.deleteById(bookingId);
			 return 1;
		}
		else {
			throw new BookingIdNotFoundException("Cannot cancel the Order, there is order with that Booking Id");
		}
		
	}

	@Override
	public int giveFeedback(int barberId, int par1, int par2, int par3) throws BarberIdNotFoundException{
		int ratingBarber = 0;
		if(barRepos.existsById(barberId)) {
			
			ratingBarber = (int)(par1+par2+par3)/3;
			
		}
		else {
			throw new BarberIdNotFoundException("Cannot take the feedback, there is No Barber with that Id");
		}
		
		return ratingBarber;
		
	}

	@Override
	public List<Booking> viewBookedOrders(int customerId) throws CustomerNotFoundException{
		
		if(cusRepos.existsById(customerId) != true ) {
			throw new CustomerNotFoundException("Customer with that Id is not found, cannot view Booked Orders");
		}
		else {
			Customer c = cusRepos.getById(customerId);
			LocalDate currentDate = LocalDate.now();
			LocalTime currentTime = LocalTime.now();
			List<Booking> bookings = c.getBookings();
			List<Booking> result = new ArrayList<Booking>();
			for(Booking b: bookings) {
				if(LocalDate.parse(b.getDateofService()).isAfter(currentDate)) {
					result.add(b);
				}                                    
				else if(LocalTime.parse(b.getStartTime()).isAfter(currentTime) && LocalDate.parse(b.getDateofService()).isEqual(currentDate)) {
					result.add(b);
				}
			} 
			return result;
		}
		
		
	}

	@Override
	public List<Booking> viewPreviousOrders(int customerId) throws CustomerNotFoundException{
		
		if(cusRepos.existsById(customerId) != true ) {
			throw new CustomerNotFoundException("Customer with that Id is not found, cannot view Previous Booked Orders");
		}
		else {
			Customer c = cusRepos.getById(customerId);
			LocalDate currentDate = LocalDate.now();
			LocalTime currentTime = LocalTime.now();
			List<Booking> bookings = c.getBookings();
			List<Booking> result = new ArrayList<Booking>();
			for(Booking b: bookings) {
				if(LocalDate.parse(b.getDateofService()).isBefore(currentDate)) {
					result.add(b);
				}
				else if(LocalTime.parse(b.getEndTime()).isBefore(currentTime)&& LocalDate.parse(b.getDateofService()).isEqual(currentDate)) {
					result.add(b);
				}
				
			}
			return result;
		}
		
	}

	@Override
	public List<String> getNameOfBarber(int barberId) throws BarberIdNotFoundException{
		if(barRepos.existsById(barberId) != true ) {
			throw new BarberIdNotFoundException("Cannot get name of the Barber");
		}
		return barRepos.getNameofBarberbyId(barberId);
	}

	@Override
	public double getCostPerSessionbyid(int barberId) throws BarberIdNotFoundException{
		
		if(barRepos.existsById(barberId) != true ) {
			throw new BarberIdNotFoundException("Cannot get cost of the Barber");
		}
		return barRepos.getCostPerSessionbyId(barberId);
	}

	@Override
	public double getCostofTheServiceatLast(int barberId, int serviceId) throws BarberIdNotFoundException,ServiceNotFoundException{
		if(barRepos.existsById(barberId) != true ) {
			throw new BarberIdNotFoundException("Barber with that Id does not exist");
		}
		else if(serRepos.existsById(serviceId) != true) {
			throw new BarberIdNotFoundException("Service with that Id does not exist");
		}
		double costatlast = serRepos.getCostOfService(serviceId)+ getCostPerSessionbyid(barberId);
		return costatlast;
	}

	
	
	
}


