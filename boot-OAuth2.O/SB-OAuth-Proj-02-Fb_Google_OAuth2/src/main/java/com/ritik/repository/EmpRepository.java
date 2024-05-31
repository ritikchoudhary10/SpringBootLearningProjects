package com.ritik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritik.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

	public List<Employee> getByDeptno(Integer deptno);
}
