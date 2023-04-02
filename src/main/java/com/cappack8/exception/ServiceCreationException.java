package com.cappack8.exception;

public class ServiceCreationException extends Exception {
	
	public ServiceCreationException()
	{
		super();
	}
	public ServiceCreationException(String errorMsg)
	{
		super(errorMsg);
	}

}
