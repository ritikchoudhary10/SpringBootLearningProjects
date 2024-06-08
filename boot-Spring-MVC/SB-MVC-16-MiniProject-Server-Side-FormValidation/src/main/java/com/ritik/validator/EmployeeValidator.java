package com.ritik.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ritik.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//typecast in model class
		Employee emp = (Employee) target;
		log.info(emp.toString());
		
		//validation for ename
		if(emp.getEname().isBlank()|| emp.getEname()==null)
			errors.rejectValue("ename", "emp.ename.required");
		else if(emp.getEname().length()<5 || emp.getEname().length()>15)
			errors.rejectValue("ename", "emp.ename.length");
		
		//validation for job 
		if(emp.getJob().isBlank()|| emp.getJob()==null)
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<5 || emp.getJob().length()>15)
			errors.rejectValue("job", "emp.job.length");
		
		//validation for sal
		if(emp.getSal()==null)
			errors.rejectValue("sal", "emp.sal.required");
		else if(emp.getSal()<200.0 || emp.getSal()>50000.0)
			errors.rejectValue("sal", "emp.sal.range");
		
		//validation for deptno
		if(emp.getDeptno()==null)
			errors.rejectValue("deptno", "emp.deptno.required");
		else if(!(emp.getDeptno()==10 || emp.getDeptno()==20 || emp.getDeptno()==30))
			errors.rejectValue("deptno", "emp.deptno.range");

	}

}
