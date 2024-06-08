package com.ritik.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ritik.entity.Employee;
import com.ritik.service.IEmployeeService;
import com.ritik.validator.EmployeeValidator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private EmployeeValidator validator;

	@Autowired
	private IEmployeeService ser;
	
	@GetMapping({"/" ,"/home"})
	public String getHomePage() {
		//retrurn LVN
		return "home";
	}
	
	@GetMapping("/report")
	public String getAllEmployeedata(Map<String , Object> sharedMemory) {
		List<Employee> allEmp = ser.getAllEmp();
		log.info(allEmp.toString());
		sharedMemory.put("empList", allEmp);
		//return LVN
		return "report"; 
	}
	
	@GetMapping("/add")
	public String addEmployeeDetails(@ModelAttribute("emp") Employee employee ) {
		
			
		
		//return LVN
		return "add_employee";
	}
	
	//double posting problem if we refresh the page then same 
	/*@PostMapping("/add") 
	public String addEmplyeeDetails(@ModelAttribute("emp") Employee employee ,Map<String, Object> sharedMemory) {
		String msg = ser.addEmployee(employee);
		List<Employee> allEmp = ser.getAllEmp();  -->code redendency same logic is repeated 
		sharedMemory.put("empList", allEmp);
		sharedMemory.put("resultMsg", msg);
		//return LVN
		return "report";
	}*/
	
	// Solution for Double Posting problem is  PRG{POST-REDIRECT-GET} design pattern
	@PostMapping("/add") 
	public String addEmplyeeDetails(@ModelAttribute("emp") Employee employee ,
									//Map<String, Object> sharedMemory -->this cannot be used since it of request scope
									RedirectAttributes redirectSharedMemory, // redirect scope memory
									BindingResult error
									) {
		

		if(validator.supports(employee.getClass())) {
			validator.validate(employee, error);
			if(error.hasErrors())
				return "add_employee";
		}
		
		
		String msg = ser.addEmployee(employee);
		//List<Employee> allEmp = ser.getAllEmp(); -->no code redendency this logic is executed from report handler method
		redirectSharedMemory.addFlashAttribute("resultMsg", msg);
		//redirecting to reports page for not getting Double posting problem
		return "redirect:report";
	}
	
	@GetMapping("/update")
	public String updateEmployee(@RequestParam("empno") Integer empno ,@ModelAttribute("emp") Employee emp) {
		try {
			Employee employee = ser.getEmployeeById(empno);
			BeanUtils.copyProperties(employee, emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return LVN
		return "edit_employee";
	}
	
	@PostMapping("/update")
	public String updateEmployeeInfo(@ModelAttribute("emp") Employee emp ,
									RedirectAttributes redirectScopeSharedmemory,
									BindingResult error
			) {
		
		if(validator.supports(emp.getClass())) {
			validator.validate(emp, error);
			if(error.hasErrors())
				return "edit_employee";
		}
		
		
		redirectScopeSharedmemory.addFlashAttribute("resultMsg",ser.updateEmployeeDetails(emp));
		//redirecting to reports page for not getting Double posting problem
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployeeInfo(@RequestParam("empno") Integer id,RedirectAttributes reddirectScopeSharedMemory) {
		 String resultMsg = ser.deleteEmployee(id);
		 reddirectScopeSharedMemory.addFlashAttribute("resultMsg", resultMsg);
		 return "redirect:report";
	}
	
	
}
