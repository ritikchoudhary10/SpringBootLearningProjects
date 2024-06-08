package com.ritik.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ritik.entity.Employee;

public interface IEmployeeService {

	public Page<Employee> getAllEmpByPage(Pageable pageable) ;
	public String addEmployee(Employee emp);
	public Employee getEmployeeById(Integer id) throws Exception;
	public String updateEmployeeDetails(Employee emp);
	public String deleteEmployee(Integer id);
}
