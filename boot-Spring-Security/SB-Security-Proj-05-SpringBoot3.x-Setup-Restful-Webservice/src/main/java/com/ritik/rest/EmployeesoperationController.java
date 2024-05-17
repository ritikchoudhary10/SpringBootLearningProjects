package com.ritik.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.entity.Employee;
import com.ritik.model.ErrorMsg;
import com.ritik.service.EmployeeService;

@RestController
@RequestMapping("/emp-api")
public class EmployeesoperationController {

	@Autowired
	private EmployeeService ser;
	
	@GetMapping("/")
	public String getHomepage() {
		return ser.employeeHome();
	}
	
	@GetMapping("/report/empno/{id}")
	public ResponseEntity<?> fingById(@PathVariable(name = "id") Integer id){
		try {
		Employee byId = ser.findById(id);
		return new ResponseEntity<Employee>(byId ,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ErrorMsg>(ErrorMsg.getError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report/deptno/{deptno}")
	public ResponseEntity<?> findByDeptno(@PathVariable(name = "deptno") Integer deptno){
		try {
			List<Employee> byDeptNo = ser.findByDeptNo(deptno);
			return new ResponseEntity<List<Employee>>(byDeptNo ,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ErrorMsg>(ErrorMsg.getError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report")
	public ResponseEntity<List<Employee>> findAll(){
		return new ResponseEntity<List<Employee>>(ser.findAllEmp(),HttpStatus.OK);
	}
	
	@PostMapping("/admin/register")
	public String addEmployee(@RequestBody Employee emp) {
		return ser.addEmployee(emp);
	}
	
	
}
