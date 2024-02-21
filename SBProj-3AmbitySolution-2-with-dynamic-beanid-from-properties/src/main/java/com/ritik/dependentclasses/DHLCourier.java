package com.ritik.dependentclasses;

import org.springframework.stereotype.Component;

@Component("dhl")
public class DHLCourier implements Courier {

	@Override
	public String receivedOrder() {
		return "Order Received By DHL courier service";
	}

	@Override
	public String orderDispatched() {
		return "Order Dispatched By DHL courier service";
	}

	@Override
	public String orderDelivered() {
		return "Order delivered By DHL courier service";
	}

}
