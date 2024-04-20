package com.ritik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritik.entity.Customer;
import com.ritik.model.CustomerView;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//     static scalar view 
	
	public List<CustomerView> findBybillAmtBetween(Double start , Double end);
	
}
