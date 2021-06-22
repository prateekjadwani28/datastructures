package com.dsa.exception;

public class StackUnderflownException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackUnderflownException() {
		super();
		System.out.println("Stack has been underflowed");
	}
}
