package com.ritik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.bean.Employee;
import com.ritik.dao.IEmployeeDAO;

@Service
public class EmployeeManagerServiceImpl implements IEmployeeManagerService {

	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	public List<Employee> fetchEmployeesByDesgn(String desgn1, String desgn2, String desgn3) throws Exception {
		desgn1=ucNames(desgn1);
		desgn2=ucNames(desgn2);
		desgn3=ucNames(desgn3);
		
		List<Employee> list =dao.getEmployeesByDesgn(desgn1, desgn2, desgn3);
		
		return list;
	}
	
	private String ucNames(String desgn){
		return desgn.toUpperCase();
	}

}
