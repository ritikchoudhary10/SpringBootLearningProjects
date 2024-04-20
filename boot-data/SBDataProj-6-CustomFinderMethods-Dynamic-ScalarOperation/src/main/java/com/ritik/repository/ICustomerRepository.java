package com.ritik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritik.entity.Customer;
import com.ritik.views.View;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//     dynamic scalar view 
	public <T extends View> List<T> findBycName(String cName ,Class<T> clazz);
	public <T extends View> List<T> findBycNameContaining(String chars ,Class<T> clazz);
	public <T extends View> List<T> findBybillAmtGreaterThan(Double billAmt ,Class<T> clazz);
	
	
}
