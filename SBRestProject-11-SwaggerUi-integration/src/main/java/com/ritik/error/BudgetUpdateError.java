package com.ritik.error;

@SuppressWarnings("serial")
public class BudgetUpdateError extends RuntimeException {
	
	public BudgetUpdateError(String errMsg) {
		super(errMsg);
	}
			
}
