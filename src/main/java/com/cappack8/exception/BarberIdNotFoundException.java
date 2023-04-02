package com.cappack8.exception;

public class BarberIdNotFoundException  extends Exception {
	public BarberIdNotFoundException()
	{
		super();
	}
	public BarberIdNotFoundException(String errorMsg)
	{
		super(errorMsg);
	}
}

