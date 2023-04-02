package com.cappack8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cappack8.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

}