package com.ritik.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("pbean")
public class Patient {

	private Integer pId;
	private String pName;
	private String pState;
	private Integer age;

}
