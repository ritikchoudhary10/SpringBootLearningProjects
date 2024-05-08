package com.ritik.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class SeasonFinderService {

	public String findSeason() {
		int month=Calendar.getInstance().get(Calendar.MONTH);
		System.out.println(month); 
		if(month>=3 && month<6)
			return "(Auntyji Pani Pila Dijiye) SUMMER SEASON";
		if(month>=6 && month<9)
			return "(Water Water every where) RAINNY SEASON";
		return "(Wear Divya Thermo Keeps Hot inside) WINTER SEASON";
	}
}
