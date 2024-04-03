package com.ritik.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="tourist_data")
public class Tourist {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer tId;
	@NonNull
	@Column(length = 20)
	private String name;
	@ NonNull
	@Column(length = 25)
	private String packageType;
	@Column(length = 25)
	@ NonNull
	private String packageName;
	@Column(length = 20)
	@ NonNull
	private String packageDuration;
	@ NonNull
	private LocalDate startsFrom;
	@ NonNull
	private LocalDate validTill;
	@ NonNull
	private Double budget;
}


