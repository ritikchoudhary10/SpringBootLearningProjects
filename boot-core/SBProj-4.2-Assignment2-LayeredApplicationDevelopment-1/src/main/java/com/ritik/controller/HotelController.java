package com.ritik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ritik.bean.Hotel;
import com.ritik.service.HotelService;
@Controller("hotelController")
public class HotelController {
	
	@Autowired
	HotelService hs;
	
	public List<Hotel> getDetails(String name1 , String name2, String name3) throws Exception{
		return hs.gethotelDetails(name1, name2, name3);
	}
}
