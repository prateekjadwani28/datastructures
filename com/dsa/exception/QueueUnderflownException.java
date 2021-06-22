package com.dsa.exception;

public class QueueUnderflownException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueueUnderflownException() {
		super();
		System.out.println("Queue has been underflowed");
	}
}
