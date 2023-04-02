package com.cappack8.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cappack8.model.Customer;


@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> , JpaRepository<Customer, Integer>{

}
