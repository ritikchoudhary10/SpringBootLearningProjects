package com.ritik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private Integer sid;
	private String sname;
	private String sadd="hyd";
	private Double avgMarks;
}
