package com.ritik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ritik.entity.Employee;
import com.ritik.repository.EmpRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmpRepository repo;
	
	
	@Override
	public Page<Employee> getAllEmpByPage(Pageable pagable) {
		return repo.findAll(pagable);
	}


	@Override
	public String addEmployee(Employee emp) {
		upperCase(emp);
		return "Employee Saved With ID :: "+repo.save(emp).getEmpno();
	}
	
	@Override
	public Employee getEmployeeById(Integer id) throws Exception {
		return repo.findById(id).orElseThrow(()->new IllegalAccessException("Employee Not Found..!"));
	}
	
	@Override
	public String updateEmployeeDetails(Employee emp) {
		upperCase(emp);
		return repo.save(emp).getEmpno()+" Employee Details Update Successfully";
	}
	
	private void upperCase(Employee emp) {
		emp.setEname(emp.getEname().toUpperCase());
		emp.setJob(emp.getJob().toUpperCase());
	}
	
	@Override
	public String deleteEmployee(Integer id) {
		repo.deleteById(id);
		return "Employee with id "+id+" is deleted Successfully";
	}

}
