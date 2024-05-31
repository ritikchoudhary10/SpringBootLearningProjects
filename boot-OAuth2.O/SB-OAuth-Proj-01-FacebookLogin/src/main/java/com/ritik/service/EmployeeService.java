package com.ritik.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.entity.Employee;
import com.ritik.repository.EmpRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmpRepository repo;
	
	public Employee findById(Integer id) throws Exception {
		Optional<Employee> optional = repo.findById(id);
		if(optional.isEmpty())
			throw new IllegalArgumentException("Employee with id "+id+" not found");
		return optional.get();
	}
	
	public List<Employee> findByDeptNo(Integer deptno) throws Exception{
		List<Employee> employees = repo.getByDeptno(deptno);
		if(employees.isEmpty())
			throw new IllegalArgumentException("Enter correct deptno...!");
		return employees;
	}
	
	public String addEmployee(Employee emp) {
		Integer save = repo.save(emp).getEmpno();
		return "Employee id "+save+" generated Successfully...!";
	}
	
	public String employeeHome() {
		return "Welcome to employee-api ";
	}
	
	public List<Employee> findAllEmp(){
		return repo.findAll();
	}
}
