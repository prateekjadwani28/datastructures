package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue{
	
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
	public void push(int data) {
		q1.add(data);
	}
	
	public int pop() {
		
		if(q1.isEmpty())
			return -1;
		
		while(q1.size()!=1) {
			q2.add(q1.remove());
		}
		
		int temp = q1.poll();
		Queue<Integer> q = q1;
		q1 = q2;
		q2=q;
		
		return temp;
	}
	public void printStack() {
		if(q1.isEmpty()) {
			return;
		}
		else {
			System.out.println("Stack element is : " + q1);
		}
	}
}
public class ST03_ImplementStackUsingQueue {

	public static void main(String arg[]) {
		
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.printStack();
		System.out.println(stack.pop());
		stack.push(9);
		stack.printStack();
		System.out.println(stack.pop());
		stack.printStack();
	}
}
