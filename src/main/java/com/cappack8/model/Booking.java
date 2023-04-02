package com.cappack8.model;

import java.time.LocalDate;


import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "Bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@DecimalMin(value="1",message="minimum value should be one")

	private int bookingId;
	@DecimalMin(value="1",message="minimum value should be one")

    private int cid;
	@DecimalMin(value="1",message="minimum value should be one")

    private int barberId;
	@NotBlank(message="barbername should not be blank")

    private String barberName; 
	@DecimalMin(value="1",message="minimum value should be one")

    private int serviceid;
	@NotBlank(message="servicename should not be blank")

	private String serviceName;
	
    private String startTime;
    private String endTime;
    private LocalDate dateofBooking;
    private String dateofService;
    private Availability available;
    
    private double costatLast;
     
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getBarberId() {
		return barberId;
	}
	public void setBarberId(int barberId) {
		this.barberId = barberId;
	}
	public String getBarberName() {
		return barberName;
	}
	public void setBarberName(String barberName) {
		this.barberName = barberName;
	}
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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
	public LocalDate getDateofBooking() {
		return dateofBooking;
	}
	public void setDateofBooking(LocalDate dateofBooking) {
		this.dateofBooking = dateofBooking;
	}
	public String getDateofService() {
		return dateofService;
	}
	public void setDateofService(String dateofService) {
		this.dateofService = dateofService;
	}
	public Availability getAvailable() {
		return available;
	}
	public void setAvailable(Availability available) {
		this.available = available;
	}
	public double getCostatLast() {
		return costatLast;
	}
	public void setCostatLast(double costatLast) {
		this.costatLast = costatLast;
	}
	
    
    
}
