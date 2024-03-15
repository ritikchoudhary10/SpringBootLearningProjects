package com.ritik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@SequenceGenerator(name = "Identity" , initialValue = 101 ,sequenceName ="SEQ_STD",allocationSize = 1 )
	@GeneratedValue(generator = "Identity",strategy = GenerationType.SEQUENCE)
	private Long stdId;
	private String stdname;
	private Long stdContact;
	private String stdAdrr;
	
	public Student(Long stdId) {
		this.stdId = stdId;
	}
	
	
}
