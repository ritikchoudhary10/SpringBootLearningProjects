package com.ritik.dependentclasses;

import org.springframework.stereotype.Component;

@Component("bd")
public class BlueDartCourier implements Courier {

	

	@Override
	public String receivedOrder() {
		return "Order Received By BlueDart courier service";
	}

	@Override
	public String orderDispatched() {
		return "Order Dispatched By BlueDart courier service";
	}

	@Override
	public String orderDelivered() {
		return "Order delivered By BlueDart courier service";
	}

}
