package com.ritik.entity;

import jakarta.persistence.Column;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Jpa_Customers")
public class Customer {
	public Customer(Integer cId) {
		this.cId=cId;
	}

	@Id
	@SequenceGenerator(sequenceName = "cust_Seq",name = "seq" ,initialValue = 1001 ,allocationSize = 1)
	@GeneratedValue(generator = "seq" ,strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private Integer cId ;
	@Column(name="cust_name" ,length = 20)
	@NonNull
	private String cName;
	@Column(name="cust_city" ,length = 20)
	@NonNull
	private String cCity;
	@Column(name="cust_billAmt" ,length = 20)
	@NonNull
	private Double billAmt;
}
