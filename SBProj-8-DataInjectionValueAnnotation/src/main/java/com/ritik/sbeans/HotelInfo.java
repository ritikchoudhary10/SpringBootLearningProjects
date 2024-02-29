package com.ritik.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("hInfo")
public class HotelInfo {
	@Value("${hotel.id}")
	private Integer id;
	@Value("${hotel.owner}")
	private String owner;
	@Value("#{menu.idly+menu.puri+(menu.idly+menu.puri)*0.05}")//this is known as SPEL 
																//-> Spring Expression Language 
	private Double billAmount;
	
	
	@Override
	public String toString() {
		return "HotelInfo [id=" + id + ", owner=" + owner + ", billAmount=" + billAmount + "]";
	}
	
	

}
