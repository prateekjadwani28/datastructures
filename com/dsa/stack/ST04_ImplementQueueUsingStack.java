package com.dsa.stack;

import java.util.Stack;

class QueueUsingStack{
	
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	public void enQueue(int data) {
		stack1.push(data);
	}
	
	public int deQueue() {
		if(stack2.size()!=0)
			return stack2.pop();
		
		if(stack1.empty())
			return -1;
		
		while(stack1.size()!=0)
			stack2.push(stack1.pop());
		return stack2.pop();
	}
}

public class ST04_ImplementQueueUsingStack {

	public static void main(String[] args) {

		QueueUsingStack q = new QueueUsingStack();
		
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(7);
		q.enQueue(5);
		
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		
		q.enQueue(9);
		
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}

}
