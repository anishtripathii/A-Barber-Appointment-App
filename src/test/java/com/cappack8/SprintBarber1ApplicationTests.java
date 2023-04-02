package com.cappack8;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
 

import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import com.cappack8.dao.BarberDaoForAdmin;
import com.cappack8.dao.BarberDaoForCustomer;
import com.cappack8.exception.BarberCreationException;
import com.cappack8.exception.BarberIdNotFoundException;
import com.cappack8.exception.BookingIdNotFoundException;
import com.cappack8.exception.CustomerNotFoundException;
import com.cappack8.exception.ServiceNotFoundException;
import com.cappack8.model.Barber;
import com.cappack8.model.Booking;
import com.cappack8.model.Services;
import com.cappack8.model.TimeSlots;
import com.cappack8.repository.BarberRepository;



@SpringBootTest
class SprintBarber1ApplicationTests {

	
		
		
		 
		
		    @Autowired
		    private BarberRepository barberRepos;
		   
		@Autowired
		BarberDaoForAdmin service;
		@Autowired
		BarberDaoForCustomer service1;

		   /* @Test
		    public void testSave() throws BarberCreationException
		    {
		    Barber b=new Barber();
		    b.setBarberId(344);
		    b.setFirstName("riyan");
		    b.setLastName("gargh");
		    b.setRatings(8);
		    b.setCostpersession(200.00);
		    
		    Services s=new Services();
		    s.setCategory("nails");
		    s.setCostofservice(100.00);
		    s.setServiceId(564);
		    s.setServiceName("manicure");
		    Services s1=new Services();
		    s1.setCategory("hair");
		    s1.setCostofservice(100.00);
		    s1.setServiceId(664);
		    s1.setServiceName("cut");
		    List<Services> ListOfServices=new ArrayList();
		    ListOfServices.add(s);
		    ListOfServices.add(s1);



		TimeSlots ts=new TimeSlots();
		ts.setDays("Monday");
		ts.setEndTime("14:00:00");
		ts.setStartTime("9:00:00");
		ts.setStatus("available");
		ts.setTimeId(113);
		TimeSlots ts1=new TimeSlots();
		ts1.setDays("tuesday");
		ts1.setEndTime("14:00:00");
		ts1.setStartTime("9:00:00");
		ts1.setStatus("available");
		ts1.setTimeId(214);
		
		List<TimeSlots> ListOfTimeSlots=new ArrayList();
		ListOfTimeSlots.add(ts1);
		ListOfTimeSlots.add(ts);
		    b.setServices(ListOfServices);
		    b.setSlots(ListOfTimeSlots);
		    //trainRepos.save(train);

		        Barber b1=null;
		       
		            b1 = service.addBarber(b);
		        
		    //    
		    assertNotNull(b1);
		    //In this case test case will pass if you will initialize null bvalue
		    //assertNull(t);
		 
		    //asseertNull();
		    //assertNo
		    }*/

		    @Test
		    public  void testviewAllBarbers()
		    {

		    List<Barber> list=    service.viewAllBarbers();
		    assertThat(list).size().isGreaterThan(0);
		    }
		    @Test
		    public  void testviewBarbersBySortedRating()
		    {

		    List<Barber> list=    service.viewBarbersBySortedRating();
		    assertThat(list).size().isGreaterThan(0);
		    }
		    @Test
		    public  void testviewServicesofBarber() throws BarberIdNotFoundException
		    {

		    List<Services> list=    service.viewServicesofBarber(1);
		    assertThat(list).size().isGreaterThan(0);
		    }
		    @Test
		    public  void testviewTimeSlotsofBarber() throws BarberIdNotFoundException
		    {

		    List<TimeSlots> list=    service.viewTimeSlotsofBarber(1);
		    assertThat(list).size().isGreaterThan(0);
		    }
		    @Test
		    public void testForUpdate()
		    {

		        Barber t=barberRepos.findById(1).get();
		        t.setCostpersession(500.0);
		        barberRepos.save(t);
		        //assertNotEquals("xyz", trainRepos.findById(1144).get().getTarinName());
		    assertNotEquals(200.0, barberRepos.findById(1).get().getCostpersession());    

		    }
		    @Test
		    public void testForcancelOrder() throws BookingIdNotFoundException
		    {
		        int status=service1.cancelOrder(5);
		        assertEquals(1, status);
		    }
		    @Test
		    public void testchangeTheService() throws BarberIdNotFoundException
		    {

		        int status=service1.changeTheService("pedicure",4,56);
		        
		        //assertNotEquals("xyz", trainRepos.findById(1144).get().getTarinName());
		    assertEquals(1,status);    

	    }
		    @Test
		    public void testgiveFeedback() throws BarberIdNotFoundException {
		    	
		    	int r=service1.giveFeedback(1, 7, 7, 7);
		    	
		    	assertEquals(r, 7);
		    }
		    @Test
		    public  void testviewBookedOrders() throws BarberIdNotFoundException, CustomerNotFoundException
		    {

		    List<Booking> list=    service1.viewBookedOrders(1);
		    assertThat(list).size().isGreaterThan(0);
		    }
		    @Test
		    public  void testviewPreviousOrders() throws BarberIdNotFoundException, CustomerNotFoundException
		    {

		    List<Booking> list=    service1.viewPreviousOrders(1);
		    assertThat(list).size().isGreaterThan(0);
		    }
		    
		
		    @Test
		    public void testgetNameOfBarber() throws BarberIdNotFoundException {
		    	List<String> list=service1.getNameOfBarber(1);
				String Bname = String.join(" ", list);
		    	assertEquals(Bname,"aditya,labba");

				

		    	
		    }
		    @Test
		    public void testgetCostofTheServiceatLast() throws BarberIdNotFoundException, ServiceNotFoundException {
		    	double d=service1.getCostofTheServiceatLast(34,56);
		    	assertEquals(d,300);

				

		    	
		    }
		    @Test
		    public void testgetCostPerSessionbyid() throws BarberIdNotFoundException, ServiceNotFoundException {
		    	double d=service1.getCostPerSessionbyid(34);
		    	assertEquals(d,200);

				

		    	
		    }
	}

