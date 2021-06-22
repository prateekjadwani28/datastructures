package com.dsa.linkedlist;


class LL24_RotateDLL 
{ 

	static class Node 
	{ 
		int data; 
		Node next, prev; 
	}; 

	static Node leftRotate( Node head, int n) 
	{
		Node current = head;
		while(current!=null && n>1) {
			current = current.next;
			n--;
		}
		
		// 5 6 8 9 - current || head 1 2 4 5 6 8 9

		Node dummy = current.next; // 8 9 -- 1 2 4 5 6
		dummy.prev = null;
		current.next = null;
		
		Node node = dummy;
		while(node!=null && node.next!=null) {
			node = node.next;
		}
		
		node.next = head;
		
		return dummy;
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
		int x = 5; 

		Node dummy = leftRotate(head, x); 
		printLinkedList(dummy);
	} 
} 