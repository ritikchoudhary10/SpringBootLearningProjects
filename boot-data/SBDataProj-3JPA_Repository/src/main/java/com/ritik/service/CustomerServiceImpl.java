package com.ritik.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ritik.entity.Customer;
import com.ritik.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public String deleteCustomersByIdsInBatch(List<Integer> ids) {
		custRepo.deleteAllById(ids);
		return "All customers with given Ids are Deleted Successfully....!";
	}

	@Override
	public List<Customer> showCustomersByExampleData(Customer cust, boolean flagOrder, String... properties) {
		Sort sort = Sort.by(flagOrder?Direction.ASC:Direction.DESC, properties);
		Example<Customer> obj =Example.of(cust);
		return custRepo.findAll(obj,sort);
	}

	@Override
	public Customer showCustomerById(int cno) {
		return custRepo.getReferenceById(cno);
	}

	@Override
	public Optional<Customer> fetchCustomerById(int cno) {
		return custRepo.findById(cno);
	}
	
	@Override
	public String saveCustomer(Customer cust) {
		Integer cId = custRepo.save(cust).getCId();
		return "Customer save with Id -> "+cId;
	}

	
}
