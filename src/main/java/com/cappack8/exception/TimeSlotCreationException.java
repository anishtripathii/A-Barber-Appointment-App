package com.cappack8.exception;

public class TimeSlotCreationException extends Exception {
	
	public TimeSlotCreationException()
	{
		super();
	}
	public TimeSlotCreationException(String errorMsg)
	{
		super(errorMsg);
	}
}
