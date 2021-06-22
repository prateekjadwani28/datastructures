package com.dsa.stack;

import com.dsa.exception.QueueOverflownException;
import com.dsa.exception.QueueUnderflownException;

class QueueUsingArray{
	int rear;
	int front;
	int max;
	int array[];
	
	public QueueUsingArray(int size) {
		front = -1;
		rear = -1;
		max = size;
		array = new int[max];
	}
	
	public void enQueue(int data) throws Exception {
		
		if(rear >= max-1)
			throw new QueueOverflownException();
		else if(front == -1 && rear == -1) {
			front = rear = 0;
			array[rear] = data;
		}
		else {
			rear++;
			array[rear] = data;
		}
	}
	
	public int deQueue() throws Exception{
		if(front == -1 && rear == -1)
			throw new QueueUnderflownException();
		else if(front == rear) {
			front = rear = -1;
			return array[0];
		}
		else {
			int data = array[front];
			front++;
			return data;
		}
	}
	public void display() {
		for(int i=front;i<=rear;i++) {
			System.out.print(array[i]+" ");
		}
	}
}

public class ST02_ImplementQueueUsingArray {
	public static void main(String args[]) {
		QueueUsingArray queue = new QueueUsingArray(5);
		try {
			queue.enQueue(2);
			queue.enQueue(3);
			queue.enQueue(4);
			queue.display();
			System.out.println();
			queue.deQueue();
			queue.enQueue(5);
			queue.enQueue(6);
			queue.display();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
