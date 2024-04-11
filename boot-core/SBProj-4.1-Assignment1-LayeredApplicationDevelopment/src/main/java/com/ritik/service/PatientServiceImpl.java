package com.ritik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.bean.Patient;
import com.ritik.dao.PatientInfoDao;
@Service("pservice")
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientInfoDao dao;
	
	
	@Override
	public List<Patient> getPatientInfo(String state1, String state2, String state3) throws Exception {
		state1=state1.toUpperCase();
		state2=state2.toUpperCase();
		state3=state3.toUpperCase();
		return dao.getAllPatientInfo(state1, state2, state3);
	}
		
}


