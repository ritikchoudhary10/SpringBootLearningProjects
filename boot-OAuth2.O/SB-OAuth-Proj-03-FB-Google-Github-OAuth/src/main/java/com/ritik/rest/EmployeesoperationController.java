package com.ritik.rest;

import java.security.Principal;
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
import com.ritik.model.RestResponse;
import com.ritik.service.EmployeeService;
import static com.ritik.model.RestResponse.*; 

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
	public ResponseEntity<?> fingById(@PathVariable(name = "id") Integer id ,Principal principal){
		try {
		Employee byId = ser.findById(id);
		return ResponseEntity.ok(response(principal, byId, HttpStatus.OK));
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
			return new ResponseEntity<ErrorMsg>(ErrorMsg.getError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ErrorMsg>(ErrorMsg.getError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report/deptno/{deptno}")
	public ResponseEntity<?> findByDeptno(@PathVariable(name = "deptno") Integer deptno,Principal principal){
		try {
			List<Employee> byDeptNo = ser.findByDeptNo(deptno);
			return ResponseEntity.ok(response(principal, byDeptNo, HttpStatus.OK));
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
			return new ResponseEntity<ErrorMsg>(ErrorMsg.getError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ErrorMsg>(ErrorMsg.getError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report")
	public ResponseEntity<RestResponse> findAll(Principal principal){
		List<Employee> allEmp = ser.findAllEmp();
		return ResponseEntity.ok(response(principal,allEmp , HttpStatus.OK));
	}
	
	@PostMapping("/admin/register")
	public ResponseEntity<RestResponse> addEmployee(@RequestBody Employee emp,Principal principal) {
		String employee = ser.addEmployee(emp);
		return ResponseEntity.ok(response(principal,employee , HttpStatus.OK));
	}
	
	
}
