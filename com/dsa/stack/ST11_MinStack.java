package com.dsa.stack;

import com.dsa.exception.StackOverflownException;
import com.dsa.exception.StackUnderflownException;

class MinStack {
	
	int max;
	int top;
	int[] array;
	int[] min;
	
	public MinStack(int size) {
		max = size;
		top = -1;
		array = new int[max];
		min = new int[max];
	}
	
	public void push(int num) throws StackOverflownException {
		
		if(top >= max - 1)
			throw new StackOverflownException();
		else {
			top++;
			array[top] = num;
			
			if(top == 0)
				min[top] = array[top];
			else
				min[top] = Math.min(array[top], min[top-1]);
		}
	}
	
	public int pop() throws StackUnderflownException {
		
		if(top < 0)
			throw new StackUnderflownException();
		int temp = array[top];
		top--;
		
		return temp;
	}
	
	public int getMin() {
		return min[top];
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
public class ST11_MinStack {

	public static void main(String[] args) {


		MinStack stack = new MinStack(5);
		try {
			stack.push(1);
			stack.push(8);
			stack.push(5);
			stack.push(2);
			System.out.println("Min Element : "+stack.getMin());
			System.out.println();
			stack.display();
			System.out.println();
			System.out.println("Peek Element : " +stack.peek());
			System.out.println();
			System.out.println("Poped Element : " +stack.pop());
			System.out.println();
			System.out.println("Min Element : "+stack.getMin());
			System.out.println("Peek Element : " +stack.peek());
			System.out.println();
			stack.display();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
