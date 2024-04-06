package com.ritik.dependentclasses;

import org.springframework.stereotype.Component;

@Component("dtdc")
public class DTDCCourier implements Courier {	

	@Override
	public String receivedOrder() {
		return "Order Received By DTDC courier service";
	}

	@Override
	public String orderDispatched() {
		return "Order Dispatched By DTDC courier service";
	}

	@Override
	public String orderDelivered() {
		return "Order delivered By DTDC courier service";
	}

}
