package com.ritik.service;

import java.util.List;
import java.util.Optional;

import com.ritik.entity.Customer;

public interface ICustomerService {
	public String  deleteCustomersByIdsInBatch(List<Integer> ids);
 	public  List<Customer>  showCustomersByExampleData(Customer cust,boolean flatOrder,String ...properties);
 	public  Customer  showCustomerById(int cno);
 	public  Optional<Customer>  fetchCustomerById(int cno);
 	public String saveCustomer(Customer cust);
}
