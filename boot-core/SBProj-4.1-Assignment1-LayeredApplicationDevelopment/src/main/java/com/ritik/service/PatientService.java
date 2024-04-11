package com.ritik.service;

import java.util.List;

import com.ritik.bean.Patient;

public interface PatientService {

	public List<Patient> getPatientInfo(String state1 , String state2 , String state3)throws Exception;
}
