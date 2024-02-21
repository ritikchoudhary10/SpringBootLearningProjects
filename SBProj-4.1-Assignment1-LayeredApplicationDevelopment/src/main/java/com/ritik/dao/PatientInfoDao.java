package com.ritik.dao;

import java.util.List;

import com.ritik.bean.Patient;

public interface PatientInfoDao {
	public List<Patient> getAllPatientInfo(String state1 , String state2 , String state3) throws Exception;
}
