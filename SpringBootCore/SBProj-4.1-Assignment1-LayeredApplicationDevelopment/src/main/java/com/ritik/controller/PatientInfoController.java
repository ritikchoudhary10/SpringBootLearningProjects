package com.ritik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ritik.bean.Patient;
import com.ritik.service.PatientService;
@Controller("ctrlr")
public class PatientInfoController {

	@Autowired
	PatientService ps ;
	
	public List<Patient> getAllInfo(String state1 , String state2 , String state3) throws Exception{
		return ps.getPatientInfo(state1, state2, state3);
	}
}
