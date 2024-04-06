package com.ritik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.bean.Employee;
import com.ritik.dao.EmployeeDAOImpl;

@Service
public class EmployeeManagerServiceImpl implements IEmployeeManagerService {

	@Autowired
	private EmployeeDAOImpl dao;
	
	@Override
	public List<Employee> fetchEmployeesByDesgn(String desgn1, String desgn2, String desgn3) throws Exception {
		desgn1 = desgn1.toUpperCase();
		desgn2 = desgn2.toUpperCase();
		desgn3 = desgn3.toUpperCase();
		
		List<Employee> list =dao.getEmployeesByDesgn(desgn1, desgn2, desgn3);
		
		return list;
	}
	
	

}
