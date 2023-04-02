package com.cappack8.exception;

public class ServiceNotFoundException  extends Exception {
	public ServiceNotFoundException()
	{
		super();
	}
	public ServiceNotFoundException(String errorMsg)
	{
		super(errorMsg);
	}
}

