package com.ritik.bean;

import lombok.Data;
@Data
public class Employee {

		private Long empNo;
		private String empName;
		private String empJob;
		private Double salary;
		private Integer deptNo;
		@Override
		public String toString() {
			return "Employee [empNo=" + empNo + ", empName=" + empName + ", empJob=" + empJob + ", salary=" + salary
					+ ", deptNo=" + deptNo + "]";
		}
		
		

}
