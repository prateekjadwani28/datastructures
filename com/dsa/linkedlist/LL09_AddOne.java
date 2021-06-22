package com.dsa.linkedlist;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.dsa.linkedlist.LL10_AddTwoNumbers.SinglyLinkedListNode;


public class LL09_AddOne {

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
	 * 4 3 2 1
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

	static SinglyLinkedListNode addOne(SinglyLinkedListNode head) {
		
		SinglyLinkedListNode current = head;
		SinglyLinkedListNode prev = null;
		int carry = 1;
		
		while(current!=null) {
			int sum = current.data + carry;
			if(sum > 9) 
				carry = 1;
			else 
				carry = 0;
			
			current.data = sum%10;
			prev = current;
			current = current.next;
		}
		
		if(carry > 0) 
			prev.next = new SinglyLinkedListNode(carry);
		
		return head;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}
			SinglyLinkedListNode node = reverse(llist.head);

			SinglyLinkedListNode llist1 = reverse(addOne(node));

			printSinglyLinkedList(llist1);
		}


		scanner.close();
	}

}
