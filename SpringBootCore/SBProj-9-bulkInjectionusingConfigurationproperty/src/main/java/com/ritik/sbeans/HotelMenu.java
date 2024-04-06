package com.ritik.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("menu")
@ConfigurationProperties(prefix = "price")
public class HotelMenu {
	
	private Integer idly;
	private Integer dosa;
	private Integer wada;
	private Integer puri;
	
	
	
	@Override
	public String toString() {
		return "HotelMenu [idly=" + idly + ", dosa=" + dosa + ", wada=" + wada + ", puri=" + puri + "]";
	}
}
