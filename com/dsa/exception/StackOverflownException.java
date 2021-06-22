package com.dsa.exception;

public class StackOverflownException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackOverflownException() {
		super();
		System.out.println("Stack has been overflowed");
	}
}
