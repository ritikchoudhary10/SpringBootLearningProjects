package com.ritik.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {

	@Id
	private String id;
	private Double stdHeight;
	private Double stdWeight;
	@NonNull
	private String stdName;
	@NonNull
	private Integer stdAge;
	@NonNull
	private Integer scholerNo;
	@NonNull
	private Integer stdClass;
	@NonNull
	private Character stdSection;
	
}
