package com.ritik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritik.entity.Customer;


public interface CustRepository extends JpaRepository<Customer, Integer> {
	
	//Custom findByXXX methods declarations static Scalar operations
	
	
	
	
}
