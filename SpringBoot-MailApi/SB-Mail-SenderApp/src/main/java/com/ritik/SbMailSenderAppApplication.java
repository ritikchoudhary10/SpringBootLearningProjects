package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ritik.service.PurchaseService;

@SpringBootApplication
public class SbMailSenderAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SbMailSenderAppApplication.class, args);
		PurchaseService ser = ctx.getBean("purchase",PurchaseService.class);
		String[] items ={"Shirt","Jeans","Brush","Notebook"};
		double[] prices ={600.0,1000.0,70.0,220};
		String[] receivers= {"ritik19me092@satiengg.in","ritik20000710@gmail.com","premalata481@gmail.com"};
		String purchaseItem = ser.purchaseItem(items, prices, receivers);
		System.out.println(purchaseItem);
	}

}
