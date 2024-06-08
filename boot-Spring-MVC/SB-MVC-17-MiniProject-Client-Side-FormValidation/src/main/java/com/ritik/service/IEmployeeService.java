package com.ritik.service;

import java.util.List;

import com.ritik.entity.Employee;

public interface IEmployeeService {

	public List<Employee> getAllEmp() ;
	public String addEmployee(Employee emp);
	public Employee getEmployeeById(Integer id) throws Exception;
	public String updateEmployeeDetails(Employee emp);
	public String deleteEmployee(Integer id);
}
