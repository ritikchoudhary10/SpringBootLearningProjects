package com.ritik.season;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sg")
public class SeasonGenerator {

	@Autowired
	LocalDate dt ; 
	
	public String findSeason() {
		
		int month=dt.getMonthValue();
		if(month>=4 && month<7)
			return "Summer Season";
		else if(month>=7 && month <=10)
			return "Rainy Season";
		return "Winter Season";
		
	}
}
