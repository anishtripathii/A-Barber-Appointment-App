package com.cappack8.controller;

import java.time.LocalDate;





import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cappack8.model.Services;
import com.cappack8.dao.BarberDaoForCustomer;
import com.cappack8.exception.BarberIdNotFoundException;
import com.cappack8.exception.BookingCreationException;
import com.cappack8.exception.BookingIdNotFoundException;
import com.cappack8.exception.CustomerNotFoundException;
import com.cappack8.exception.ServiceNotFoundException;
import com.cappack8.model.Availability;
import com.cappack8.model.Barber;
import com.cappack8.model.Booking;

@RestController
@RequestMapping("/api")
public class BarberControllerByCustomer {
	
	@Autowired
	BarberDaoForCustomer CBarDao;
	
	
	Logger log=org.slf4j.LoggerFactory.getLogger(BarberControllerByCustomer.class);
	
	
	@GetMapping(path="/viewAllBarbersByCustomer")
	public List<Barber> viewAllBarbers1(){
		log.info("Barbers are fetched");
		return CBarDao.viewAllBarbers();

	}
	
	@GetMapping(path="/viewBarbersBasedOnRatingsByCustomer")
	public List<Barber> viewBarbersOnRatings1(){
		log.info("Barber object fetched in sorted order on the basis of rating");
		return CBarDao.viewBarbersBySortedRating();
		
	}
	
	@GetMapping(path="/viewCostOfthesessionatlast/{bid}/{sid}")
	public double viewcostatlast1(@PathVariable int bid, @PathVariable int sid) throws BarberIdNotFoundException, ServiceNotFoundException{
		
		double cost1 = CBarDao.getCostofTheServiceatLast(bid, sid);
		
		if(cost1 != 0) {
			log.info("fetched cost of service");
		}
		else {
			log.error("Unable to fetch the cost of at last the id's entered are incorrect");
		}
		
		return cost1;
		
	}
	
	/*
	@GetMapping(path="/viewNameofBarber/{id}")
	public List<String> viewNameofBarber(@PathVariable int id){
		return CBarDao.getNameOfBarber(id);
		
	}
	*/
	
	@GetMapping(path="/viewCostPerSessionByid/{id}")
	public double viewCostPerSession(@PathVariable int id) throws BarberIdNotFoundException{
		
		double cost = CBarDao.getCostPerSessionbyid(id);
		if(cost != 0) {
			log.info("fetched the cost of session");
		}
		else {
			log.error("Unable to fetch the cost per session because id is not found");
		}
		return cost;
		
	}
	
	@PostMapping(path="/createBooking/{barbId}/{custId}/{serid}/{stTime}/{endTime}/{dos}/{availa}")
	public Booking addBookings(Booking booking, @PathVariable int barbId, @PathVariable int custId, @PathVariable int serid, @PathVariable String stTime, @PathVariable String endTime , @PathVariable String dos, @PathVariable Availability availa ) throws BookingCreationException, BarberIdNotFoundException, ServiceNotFoundException {
		Booking b = CBarDao.bookAService(booking, barbId, custId, serid, stTime, endTime, dos, availa);
		if(b != null) {
			log.info("The customer booked Successfully");
		}
		else {
			log.error("Booking was not successful");
		}
		return b;
	}
	
	@GetMapping(path="/viewAllServiceOfBarber/{barberId}")
	public List<Services> viewAllServiceOfBarber(int barberId) throws BarberIdNotFoundException {
		List<Services> l = CBarDao.viewAllServiceOfBarber(barberId);
		if(l!=null) {
			log.info("Viewed All the services of Barber");
		}
		else {
			log.error("Cannot view the services of barber");
		}
		return l;
	}
	
	
	@PutMapping(path="/changeTheServiceByName/{newServiceName}/{bookingId}/{serId}")
	public int changeTheService(@PathVariable String newServiceName,@PathVariable int bookingId, @PathVariable int serId) throws BarberIdNotFoundException {
		int c = CBarDao.changeTheService(newServiceName, bookingId, serId);
		if(c != 0) {
			log.info("Updated the service successfully");
		}
		else {
			log.error("Unable to make changes in the service");
		}
		return c;
		
	}
	
	
	@DeleteMapping(path="/cancelOrder/{bookingId}")
	public int cancelOrder(@PathVariable int bookingId) throws BookingIdNotFoundException {
		
		int order = CBarDao.cancelOrder(bookingId);
		if(order != 0) {
			log.info("Cancelled the order successfully");
		}
		else {
			log.error("Unable to cancel the order");
		}
		return order;
	}
	
	
	@GetMapping(path="/giveFeedback/{barberId}/{par1}/{par2}/{par3}")
	public int giveFeedback(@PathVariable int barberId,@PathVariable int par1,@PathVariable int par2, int par3) throws BarberIdNotFoundException {
		int status = CBarDao.giveFeedback(barberId,par1,par2,par3);
		if(status != 0) {
			log.info("Took the feedback");
		}
		else {
			log.error("Cannot take the feedback for that id");
		}
		return status;
	}
	
	
	@GetMapping(path="/viewBookedOrders/{customerId}")
	public List<Booking> viewBookedOrders(@PathVariable int customerId) throws CustomerNotFoundException {
		List<Booking> lb = CBarDao.viewBookedOrders(customerId);
		if(lb!=null) {
			log.info("Viewed All the Booked orders");
		}
		else {
			log.error("Cannot view booked orders because there is no customer with that Id");
		}
		return lb;
		
	}
	
	
	@GetMapping(path="/viewPreviousOrders/{customerId}")
	public List<Booking> viewPreviousOrders(@PathVariable int customerId) throws CustomerNotFoundException {
		List<Booking> lb1 =  CBarDao.viewPreviousOrders(customerId);
		if(lb1!=null) {
			log.info("Viewed All the Previous Booked orders");
		}
		else {
			log.error("Cannot view previous booked orders because there is no customer with that Id");
		}
		return lb1;
	}
	
	

	
}