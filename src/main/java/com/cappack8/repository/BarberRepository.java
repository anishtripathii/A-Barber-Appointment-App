package com.cappack8.repository;

import java.util.List;


import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cappack8.model.Barber;
import com.cappack8.model.Services;
import com.cappack8.model.TimeSlots;


@Repository
public interface BarberRepository extends PagingAndSortingRepository<Barber, Integer> , JpaRepository<Barber, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="update Barber b set b.costpersession = :cost where b.barberId=:id")
	public int updatingcostOfBarber(int id, double cost);
	
	@Query("select b.services from Barber b where b.barberId=:id")
	public List<Services> viewServicesOfBarber(int id);
	
	@Query("select b.slots from Barber b where b.barberId=:id")
	public List<TimeSlots> viewTimeSlotsOfBarber(int id);
	
	@Query("select b.firstName, b.lastName from Barber b where b.barberId=:id")
	public List<String> getNameofBarberbyId(int id);
	
	@Query("select b.costpersession from Barber b where b.barberId=:id")
	public double getCostPerSessionbyId(int id);

}

