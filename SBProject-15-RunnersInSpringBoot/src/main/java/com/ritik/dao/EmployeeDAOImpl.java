package com.ritik.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ritik.bean.Employee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

	public static final String GET_EMPLOYEES_BY_DESGN="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	
	@Autowired
	public DataSource ds;
	
	private List<Employee> list;
	
	@Override
	public List<Employee> getEmployeesByDesgn(String desgn1, String desgn2, String desgn3) throws Exception {
		try(
				Connection con=ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_EMPLOYEES_BY_DESGN);
		){
			ps.setString(1, desgn1);
			ps.setString(2, desgn2);
			ps.setString(3, desgn3);
			
			try(ResultSet rs =ps.executeQuery()){
				 list=new ArrayList<>();
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setEmpNo(rs.getLong(1));
					emp.setEmpName(rs.getString(2));
					emp.setEmpJob(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptNo(rs.getInt(5));
					
					list.add(emp);
				}
			}
		}catch (SQLException  e) {		
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

}
