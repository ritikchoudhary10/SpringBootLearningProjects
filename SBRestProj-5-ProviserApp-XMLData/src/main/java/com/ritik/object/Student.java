package com.ritik.object;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	public Student(Integer stdId,String stdName ) {
		this.stdId=stdId;
		this.stdName=stdName;
		
	}
	
	private Integer stdId;
	private String stdName;
	private Long[] stdMobNo;
	private List<String> stdPetNames;
	private Set<String> stdMailIds ;
	private Map<String, Double> stdMarks;
	private List<Friends> friends;
	
	private Address stdAdrr;
}
