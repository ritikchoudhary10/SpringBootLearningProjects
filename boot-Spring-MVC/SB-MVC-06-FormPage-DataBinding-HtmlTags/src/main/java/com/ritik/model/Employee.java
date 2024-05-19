package com.ritik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer eId;
	private String eName;
	private String desgn;
	private Double sal; 
}
 