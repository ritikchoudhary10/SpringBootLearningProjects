package com.ritik.sbeans;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
@Setter
@Component("Std")
@ConfigurationProperties(prefix = "in.satiengg")
public class StudentInfo {

	private Long studId;
	private String studName;
	private String studAdrr;
	private List<Long> StudentMob;
	@Override
	public String toString() {
		return "StudentInfo [studId=" + studId + ", studName=" + studName + ", studAdrr=" + studAdrr + ", StudentMob="
				+ StudentMob + "]";
	}
	
	
	
}
