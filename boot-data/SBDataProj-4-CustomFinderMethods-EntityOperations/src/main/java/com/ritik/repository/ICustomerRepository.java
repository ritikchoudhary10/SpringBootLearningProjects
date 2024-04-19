package com.ritik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritik.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//	custom finder methods
	public List<Customer> findBycName(String cName);
	public List<Customer> findBycCity(String cCity);
	public List<Customer> findBybillAmt(Double billAmt);
	
//	custom finder method with conditions
	public List<Customer> findBycNameLike(String likePattern);
	public List<Customer> findBycNameStartingWith(Character start);
	public List<Customer> findBycNameEndingWith(Character end);
	public List<Customer> findBybillAmtBetween(Double start ,Double end);
	public List<Customer> findBybillAmtGreaterThanEqual(Double billAmt);
	public List<Customer> findBybillAmtLessThanEqual(Double billAmt);
	// and many more for more details check--> https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	
}
