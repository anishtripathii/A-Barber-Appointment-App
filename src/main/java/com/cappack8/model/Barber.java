package com.cappack8.model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "Barber_Details")
public class Barber {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@DecimalMin(value="1",message="minimum value should be one")

	private int barberId;
	@NotBlank(message="firstname should not be blank")
	private String firstName;
	@NotBlank(message="lastname should not be blank")
	private String lastName;
	//Ratings in the scale of 10
	private int ratings; 
	private double costpersession;
	
	@Autowired
	@OneToMany(cascade = CascadeType.ALL)
	private List<Services> services;
	
	@Autowired
	@OneToMany(cascade = CascadeType.ALL)
	private List<TimeSlots> slots;

	public int getBarberId() {
		return barberId;
	}

	public void setBarberId(int barberId) {
		this.barberId = barberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public double getCostpersession() {
		return costpersession;
	}

	public void setCostpersession(double costpersession) {
		this.costpersession = costpersession;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	public List<TimeSlots> getSlots() {
		return slots;
	}

	public void setSlots(List<TimeSlots> slots) {
		this.slots = slots;
	}
	
	

	
}
