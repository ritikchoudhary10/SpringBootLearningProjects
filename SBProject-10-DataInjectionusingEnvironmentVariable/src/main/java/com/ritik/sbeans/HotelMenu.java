package com.ritik.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("menu")
public class HotelMenu {
	
	@Value("${price.idly}")
	private Integer idly;
	@Value("${price.dosa}")
	private Integer dosa;
	@Value("${price.wada}")
	private Integer wada;
	@Value("${price.puri}")
	private Integer puri;
	
	
	
	@Override
	public String toString() {
		return "HotelMenu [idly=" + idly + ", dosa=" + dosa + ", wada=" + wada + ", puri=" + puri + "]";
	}
}
