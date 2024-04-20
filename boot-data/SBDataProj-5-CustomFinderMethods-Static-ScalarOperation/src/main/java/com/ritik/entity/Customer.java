//Customer.java
package com.ritik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
	@Id
	@SequenceGenerator(name = "CustSeq_1" ,allocationSize = 1, initialValue = 1,sequenceName = "CustomerSeq")
	@GeneratedValue(generator ="CustSeq_1" ,strategy = GenerationType.AUTO )
	private Integer cId;
	@NonNull
	private String cName;
	@NonNull
	private String cCity;
	@NonNull
	private Double billAmt;

}
