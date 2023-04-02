package com.cappack8.exception;

public class BookingIdNotFoundException extends Exception {
	
	public BookingIdNotFoundException()
	{
		super();
	}
	public BookingIdNotFoundException(String errorMsg)
	{
		super(errorMsg);
	}

}
