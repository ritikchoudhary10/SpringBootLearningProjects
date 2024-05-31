package com.ritik.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ritik.entity.Employee;
import com.ritik.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeService ser;
	
	@GetMapping({"/" ,"/home"})
	public String getHomePage() {
		//retrurn LVN
		return "home";
	}
	
	@GetMapping("/report")
	public String getAllEmployeedata(@PageableDefault(page = 0 ,size = 4 ,sort = "job" ,direction = Direction.ASC) Pageable pageable,
										Map<String , Object> sharedMemory) {
		Page<Employee> allEmp = ser.getAllEmpByPage(pageable);
		log.info(allEmp.toString());
		sharedMemory.put("empPage", allEmp);
		//return LVN
		return "report"; 
	}
	
	@GetMapping("/add")
	public String addEmployeeDetails(@ModelAttribute("emp") Employee employee) {
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
									RedirectAttributes redirectSharedMemory // redirect scope memory
									) {
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
	public String updateEmployeeInfo(@ModelAttribute("emp") Employee emp ,RedirectAttributes redirectScopeSharedmemory) {
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