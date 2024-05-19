package com.ritik.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ritik.model.Student;

@Controller
public class StudentOperationController {

	@GetMapping("/")
	public String getHome() {
		//return LVN
		System.out.println("StudentOperationController.getHome()");
		return "welcome";
	}
	
	@GetMapping("/form_student")
	public String getStudentForm(@ModelAttribute("stud") Student std ) {
		System.out.println("StudentOperationController.getStudentForm()");
		//return LVN
		return "form_student";
	}
	
//	@PostMapping("/show_result")
	@PostMapping("/form_student")
	public String processData(@ModelAttribute("stud") Student std ,Map<String, Object> sharedMemory) {
		System.out.println("StudentOperationController.processData()");
		Double avgMarks = std.getAvgMarks();
		if(avgMarks>80)
			sharedMemory.put("result", "1st Division");
		else if(avgMarks>60)
			sharedMemory.put("result" ,"2nd Division");
		else if(avgMarks>40)
			sharedMemory.put("result", "3rd Division");
		else
			sharedMemory.put("result", "Failed Try next year!!!");
		//return LVN
		return "result";
	}
}
