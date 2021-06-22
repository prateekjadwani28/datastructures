package com.dsa.linkedlist;


class LL22_CountTriplets 
{ 

	static class Node 
	{ 
		int data; 
		Node next, prev; 
	}; 

	// 1 2 3 4 5 6
	static void pairSum( Node head, int x) 
	{
		Node explorer = head;
		Node dummy = head;

		while(dummy!=null && dummy.next!=null)
			dummy = dummy.next;

		Node begin = head.next;
		Node end = dummy;
		int count = 0;

		while(explorer!=null && explorer.next!=end) {

			while(begin!=null && end!=null && begin!=end && end.next!=begin) {

				if(explorer.data + begin.data + end.data == x) {
					count++;
					begin = begin.next;
					end = end.prev;
				}
				else {
					
					if(explorer.data + begin.data + end.data < x)
						begin = begin.next;
					else
						end = end.prev;
				}
			}
			explorer = explorer.next;
			begin = explorer.next;
			end = dummy;
		}
		System.out.println(count);
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
		int x = 17; 

		pairSum(head, x); 
	} 
} 