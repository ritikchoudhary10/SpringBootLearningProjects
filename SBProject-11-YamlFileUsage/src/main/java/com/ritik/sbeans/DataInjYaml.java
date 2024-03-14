package com.ritik.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
@Setter
@Component("yaml")
@ConfigurationProperties(prefix = "com.customer")
public class DataInjYaml {
	
	
	private Long custId;
	private String custName;
	private String custMailId;
	private Long custMobNo;
	
	
	
	@Override
	public String toString() {
		return "DataInjYaml [custId=" + custId + ", custName=" + custName + ", custMailId=" + custMailId
				+ ", custMobNo=" + custMobNo + "]";
	}
	
	
	
	
	
}
