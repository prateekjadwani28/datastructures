package com.dsa.linkedlist;


class LL21_SumPairInDLL 
{ 

	static class Node 
	{ 
		int data; 
		Node next, prev; 
	}; 
	
	
	static void pairSum( Node head, int x) 
	{ 
		Node first = head; 
		Node second = head; 
		while (second.next != null) 
			second = second.next; 

		boolean found = false; 

		while (first != null && second != null && 
				first != second && second.next != first) // whil(left<right) --> left != right and left>right
		{ 
			if ((first.data + second.data) == x) 
			{ 
				found = true; 
				System.out.println( "(" + first.data + 
						", "+ second.data + ")" ); 

				first = first.next; 

				second = second.prev; 
			} 
			else
			{ 
				if ((first.data + second.data) < x) 
					first = first.next; 
				else
					second = second.prev; 
			} 
		} 

		if (found == false) 
			System.out.println("No pair found"); 
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
		head = insert(head, 7); 		
		head = insert(head, 6);
		head = insert(head, 5); 
		head = insert(head, 4); 
		head = insert(head, 2); 
		head = insert(head, 1); 
		int x = 15; 

		pairSum(head, x); 
	} 
} 