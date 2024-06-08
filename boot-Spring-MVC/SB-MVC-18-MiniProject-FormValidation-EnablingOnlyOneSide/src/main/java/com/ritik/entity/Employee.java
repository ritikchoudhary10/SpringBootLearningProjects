package com.ritik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "emp")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
	
	@Id
	@SequenceGenerator(initialValue = 1000,name = "seq_1" ,allocationSize = 1,sequenceName = "emp_seq")
	@GeneratedValue(generator = "seq_1" ,strategy = GenerationType.AUTO)
	private Integer empno;
	@NonNull
	private String ename;
	@NonNull
	private String job="CLERK";
	@NonNull
	private Double sal;
	@NonNull
	private Integer deptno;
	@Transient
	private String flag="disabled";
}
