package com.ritik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritik.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
