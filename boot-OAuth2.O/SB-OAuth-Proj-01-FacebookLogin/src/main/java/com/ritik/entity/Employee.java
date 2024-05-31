package com.ritik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "emp")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@SequenceGenerator(initialValue = 1001 ,name = "emp_gen" ,allocationSize = 1,sequenceName = "empno_generator")
	@Id
	@GeneratedValue(generator = "emp_gen" ,strategy = GenerationType.AUTO)
	private Integer empno;
	@NonNull
	private String ename;
	@NonNull
	private String job;
	@NonNull
	private Double sal;
	@NonNull
	private Integer deptno;
}
