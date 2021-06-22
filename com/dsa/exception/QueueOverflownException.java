package com.dsa.exception;

public class QueueOverflownException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueueOverflownException() {
		super();
		System.out.println("Queue has been overflowed");
	}
}
