package com.ritik.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@SQLDelete(sql = "UPDATE employee SET status='deleted' WHERE empno=?")
//@Where(clause = "status<>0")//depricated we user sqlrestriction annotation
@SQLRestriction(value = "status <> 'deleted'")
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
	private Float sal;
	@NonNull
	private Integer deptno;
	@NonNull
	private String status="active";
	
}
