
// Simple Demonstration

package com.ritik.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
@Setter
@ConfigurationProperties(prefix = "ritik")
@Component("tt")
public class DataInjClass {
	
	
	private String val1;
	
	private String val2 ;
	
	private int val3;
	
	private float val4;
	
	@Override
	public String toString() {
		return "DataInjClass [val1=" + val1 + ", val2=" + val2 + ", val3=" + val3 + ", val4=" + val4 + "]";
	}
	
	
}
