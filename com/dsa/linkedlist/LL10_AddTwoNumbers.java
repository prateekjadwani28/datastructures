package com.dsa.linkedlist;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.dsa.linkedlist.LL01_ReverseLinkedList.SinglyLinkedListNode;


public class LL10_AddTwoNumbers {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {


		SinglyLinkedListNode current = node;

		if(current == null)
			System.out.println("List is empty");
		else {
			while(current!=null) {
				System.out.print(current.data+" ");
				current = current.next;
			}
		}


	}

	// Complete the reverse function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 * 1 -> 2 -> 3 -> 4 -> null
	 */
	
	
	static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

		SinglyLinkedListNode newHead = null;

		while(head!=null) {
			
			SinglyLinkedListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}

			return newHead;

	}
	
	
	static SinglyLinkedListNode addNumbers(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		
		SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
		SinglyLinkedListNode temp = dummy;
		int carry = 0;
		
		while(head1!=null || head2!=null) {
			int sum = head1.data + head2.data + carry;
			if(sum > 9)
				carry = 1;
			else 
				carry = 0;
			
			temp.next = new SinglyLinkedListNode(sum%10);
			temp = temp.next;
			head1 = head1.next;
			head2 = head2.next;
		}
		
		if(carry > 0) {
			temp.next = new SinglyLinkedListNode(carry);
		}
		return dummy.next;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedList llist1 = new SinglyLinkedList();
			SinglyLinkedList llist2 = new SinglyLinkedList();

			int llistCount1 = scanner.nextInt();

			for (int i = 0; i < llistCount1; i++) {
				int llistItem = scanner.nextInt();
				llist1.insertNode(llistItem);
			}
			
			int llistCount2 = scanner.nextInt();
			
			for (int i = 0; i < llistCount2; i++) {
				int llistItem = scanner.nextInt();
				llist2.insertNode(llistItem);
			}

			SinglyLinkedListNode node1 = reverse(llist1.head);
			SinglyLinkedListNode node2 = reverse(llist2.head);

			SinglyLinkedListNode llist = reverse( addNumbers(node1,node2));
			printSinglyLinkedList(llist);
		


		scanner.close();
	}

}
