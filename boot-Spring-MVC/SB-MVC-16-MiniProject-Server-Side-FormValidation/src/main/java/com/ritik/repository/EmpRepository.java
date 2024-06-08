package com.ritik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritik.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
