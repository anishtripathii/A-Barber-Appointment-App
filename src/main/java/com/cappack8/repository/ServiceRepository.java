package com.cappack8.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cappack8.model.Services;



@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Services, Integer> ,  JpaRepository<Services, Integer>{
	
	@Query("select s.costofservice from Services s where s.serviceId=:id")
	public double getCostOfService(int id);
	
	@Query("select s.serviceName from Services s where s.serviceId=:id")
	public String getNameofServiceByid(int id);

	
}

