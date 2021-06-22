package com.dsa.stack;

import com.dsa.exception.StackOverflownException;
import com.dsa.exception.StackUnderflownException;

class StackUsingArray{

	int max;
	int top;
	int array[];

	StackUsingArray(int size){
		max = size;
		top = -1;
		array = new int[max];
	}

	public void push(int data) throws Exception {
		if(top >= max-1) {
			throw new StackOverflownException();
		}

		else {
			top++;
			array[top] = data;
		}
	}

	public int pop() throws Exception {
		if(top<0)
			throw new StackUnderflownException();
		else {
			int result = array[top];
			top--;
			return result;
		}
	} 

	public int peek() throws Exception{
		if(top<0)
			throw new StackUnderflownException();
		else {
			int result = array[top];
			return result;
		}
	}

	public void display() {
		System.out.println("Elements in the Stack");
		for(int i=0;i<=top;i++) {
			System.out.print(array[i]+" ");
		}
	}
}

public class ST01_ImpementStackUsingArray {

	public static void main(String[] args) {

		StackUsingArray stack = new StackUsingArray(5);
		try {
			stack.push(8);
			stack.push(5);
			stack.push(2);
			System.out.println();
			stack.display();
			System.out.println();
			System.out.println("Peek Element : " +stack.peek());
			System.out.println();
			System.out.println("Poped Element : " +stack.pop());
			System.out.println();
			System.out.println("Peek Element : " +stack.peek());
			System.out.println();
			stack.display();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
