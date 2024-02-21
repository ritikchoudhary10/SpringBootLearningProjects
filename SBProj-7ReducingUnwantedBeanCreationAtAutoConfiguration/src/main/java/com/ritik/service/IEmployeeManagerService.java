package com.ritik.service;

import java.util.List;

import com.ritik.bean.Employee;

public interface IEmployeeManagerService {

	public List<Employee> fetchEmployeesByDesgn(String desgn1 , String desgn2,String desgn3) throws Exception;
	
}
