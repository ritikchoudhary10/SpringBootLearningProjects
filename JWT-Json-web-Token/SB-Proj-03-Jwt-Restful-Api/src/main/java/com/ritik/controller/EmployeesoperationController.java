package com.ritik.controller;

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

@RestController
@RequestMapping("/emp-api")
public class EmployeesoperationController {

	@Autowired
	private EmployeeService ser;
	
	
	
	@GetMapping("/report/user/id/{id}")
	public ResponseEntity<?> fingById(@PathVariable(name = "id") Integer id,Principal p){
		try {
		Employee byId = ser.findById(id);
		return new ResponseEntity<RestResponse>(RestResponse.response(p, byId) ,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ErrorMsg>(ErrorMsg.getError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report/user/deptno/{deptno}")
	public ResponseEntity<?> findByDeptno(@PathVariable(name = "deptno") Integer deptno ,Principal p){
		try {
			List<Employee> byDeptNo = ser.findByDeptNo(deptno);
			return new ResponseEntity<RestResponse>(RestResponse.response(p, byDeptNo) ,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ErrorMsg>(ErrorMsg.getError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report/all")
	public ResponseEntity<RestResponse> findAll(Principal p){
		return new ResponseEntity<RestResponse>(RestResponse.response(p, ser.findAllEmp()),HttpStatus.OK);
	}
	
	@PostMapping("/admin/register")
	public ResponseEntity<RestResponse> addEmployee(@RequestBody Employee emp,Principal p) {
		return ResponseEntity.ok(RestResponse.response(p, ser.addEmployee(emp)));
	}
	
	
	
	
}
