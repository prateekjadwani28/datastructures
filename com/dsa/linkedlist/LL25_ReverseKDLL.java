package com.dsa.linkedlist;

import com.dsa.linkedlist.LL24_RotateDLL.Node;

class LL25_ReverseKDLL 
{ 

	static class Node 
	{ 
		int data; 
		Node next, prev; 
	}; 

	public static void printLinkedList(Node node)  {


		Node current = node;

		if(current == null)
			System.out.println("List is empty");
		else {
			while(current!=null) {
				System.out.print(current.data +" ");
				current = current.next;
			}
		}


	}

	static Node rotateList( Node head, int x){

		Node current = head;
		Node next = null;
		Node newHead = null;

		int count = 0;

		while(current!=null && count<x) {
			next = current.next;
			current.next = newHead;
			newHead = current;
			current = next;
			count++;
		}

		if(next!=null) {
			head.next = rotateList(next, x);
			head.next.prev = head;
		}

		return newHead;
	} 


	static Node insert(Node head, int data) 
	{ 
		Node temp = new Node(); 
		temp.data = data; 
		temp.next = temp.prev = null; 
		if (head == null) 
			(head) = temp; 
		else
		{ 
			temp.next = head; 
			(head).prev = temp; 
			(head) = temp; 
		} 
		return temp; 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		Node head = null; 
		head = insert(head, 9); 
		head = insert(head, 8); 
		head = insert(head, 6); 
		head = insert(head, 5); 
		head = insert(head, 4); 
		head = insert(head, 2); 
		head = insert(head, 1); 
		int x = 4; 

		System.out.println("Before Rotation");
		printLinkedList(head);
		Node node = rotateList(head, x);
		System.out.println();
		System.out.println("After Rotation");
		printLinkedList(node);
	} 
} 