package com.ritik.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
@Setter
@Component("admin")
@ConfigurationProperties(prefix = "com.admin")
public class AdminInfo {

	private Integer adminId;
	private String adminName;
	private Long adminContact;
	@Override
	public String toString() {
		return "AdminInfo [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}
	
}
