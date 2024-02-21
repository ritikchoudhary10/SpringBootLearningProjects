package com.ritik.dao;

import java.util.List;

import com.ritik.bean.Employee;

public interface IEmployeeDAO {

	public List<Employee> getEmployeesByDesgn(String desgn1 , String desgn2, String desgn3)throws Exception;

}
