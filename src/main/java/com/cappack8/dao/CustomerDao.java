package com.cappack8.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cappack8.model.Customer;
import com.cappack8.repository.CustomerRepository;

@Service
public class CustomerDao {
	
	@Autowired
	CustomerRepository cRepo;
	
	public Customer addCustomer(Customer customer) {
		return cRepo.save(customer);
	}
	
	

}
