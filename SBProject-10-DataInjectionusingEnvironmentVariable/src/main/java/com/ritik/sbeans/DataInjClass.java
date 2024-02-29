
// Simple Demonstration

package com.ritik.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("tt")
@Data
public class DataInjClass {
	
	@Autowired
	Environment env;
	
	
	
	private String val1 ;
	private String val2 ;
	private Integer val3;
	private Float val4;
	
	public void setValues() {
		val1=env.getProperty("val1");
		val2 = env.getProperty("val2");
		val3 = env.getProperty("val3" , Integer.class);
		val4 = env.getProperty("val4" , Float.class);
		
		
	}
	
	
	
	@Override
	public String toString() {
		return "DataInjClass [val1=" + val1 + ", val2=" + val2 + ", val3=" + val3 + ", val4=" + val4 + "]";
	}



	
}
