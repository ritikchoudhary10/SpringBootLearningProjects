
// Simple Demonstration

package com.ritik.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("tt")
public class DataInjClass {
	
	@Value("${val1}") // for passing direct values from properties of yml files
	private String val1;
	@Value("${val2}")
	private String val2 ;
	@Value("${val3>10?40:60}") // for passing values by performing proper validations 
	private int val3;
	@Value("${val4}")
	private float val4;
	@Override
	public String toString() {
		return "DataInjClass [val1=" + val1 + ", val2=" + val2 + ", val3=" + val3 + ", val4=" + val4 + "]";
	}
	
	
}
