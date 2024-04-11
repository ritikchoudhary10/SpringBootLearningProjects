package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.ritik.dependentclasses.Order;
import com.ritik.targetclasses.Flipkart;

@SpringBootApplication
@ImportResource(locations = {"com/ritik/targetclasses/applicationContext.xml"})
public class SbProj1Solution1Application {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SbProj1Solution1Application.class, args);
		Flipkart fk= ctx.getBean("fk" , Flipkart.class);
		Order order=new Order();
		order.setProduct("FastTrack Watch \nApple iPhone13 \nperfume");
		order.setTotalPrice("1,04,452");
		fk.deliver(order);
	}

}
