package com.ritik.model;

import java.util.Map;

import lombok.Data;

@Data
public class Student {
	
	private Integer id;
	private String name;
	private Map<String ,Double > marks;
	 
	
}
