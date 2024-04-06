package com.ritik;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ritik.bean.Hotel;
import com.ritik.controller.HotelController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		HotelController hc = ctx.getBean("hotelController",HotelController.class);
		List<Hotel> ls;
		try {
			ls = hc.getDetails("indore", "kanpur", "patna");
			ls.forEach((hotelInfo)->System.out.println(hotelInfo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
