package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ritik.sbeans.DataInjClass;
import com.ritik.sbeans.HotelInfo;
import com.ritik.sbeans.HotelMenu;

@SpringBootApplication
public class SbProj8DataInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SbProj8DataInjectionApplication.class, args);
		DataInjClass b = ctx.getBean("tt",DataInjClass.class);
		System.out.println(b);
		
		//----------------------------------
		
		HotelMenu menu = ctx.getBean("menu",HotelMenu.class);
		
		System.out.println(menu);
		
		//=====================================
		
		HotelInfo hInfo = ctx.getBean("hInfo", HotelInfo.class);
		System.out.println(hInfo);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
