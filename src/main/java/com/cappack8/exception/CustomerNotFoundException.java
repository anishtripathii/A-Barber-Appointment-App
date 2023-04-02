package com.cappack8.exception;

public class CustomerNotFoundException  extends Exception {
	public CustomerNotFoundException()
	{
		super();
	}
	public CustomerNotFoundException(String errorMsg)
	{
		super(errorMsg);
	}
}

