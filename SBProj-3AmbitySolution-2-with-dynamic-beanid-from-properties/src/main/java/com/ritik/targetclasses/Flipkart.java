package com.ritik.targetclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

import com.ritik.dependentclasses.Courier;
import com.ritik.dependentclasses.Order;
@Component("fk")

public class Flipkart {
	@Autowired
	@Qualifier("CP")//here we have to pass the alias name
	Courier courier;
	
	public void deliver(Order order) {
		System.out.println("---------------------------------------------------");
		System.out.println(courier.receivedOrder());
		System.out.println("---------------------------------------------------");
		totalItems(order);
		System.out.println("---------------------------------------------------");
		billAmmount(order);
		System.out.println("---------------------------------------------------");
		System.out.println(courier.orderDispatched());
		System.out.println("---------------------------------------------------");
		try {Thread.sleep(1300);}catch(Exception e) {}
		System.out.println("Processing");
		System.out.println("---------------------------------------------------");
		try {Thread.sleep(2000);}catch(Exception e) {}
		System.out.println(courier.orderDelivered());
		System.out.println("---------------------------------------------------");
	}
	
	
	private void billAmmount(Order order) {
		System.out.println("Ammount to be paid on COD\n----------------------------\n   -->"+order.getTotalPrice()+"$");
	}
	private void totalItems(Order order) {
		System.out.println("All items are \n----------------------|\n"+order.getProduct());
	}
}
