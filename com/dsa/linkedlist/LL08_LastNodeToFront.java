package com.dsa.linkedlist;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class LL08_LastNodeToFront {

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
	 * 
	 * 4 --> 1 --> 2 -->3-->null
	 */
	static SinglyLinkedListNode placeLastToFront(SinglyLinkedListNode head) {
		
		SinglyLinkedListNode current = head;
		
		if(head == null || head.next == null)
			return head;
		
		while(current!=null && current.next!=null && current.next.next!=null) {
			current = current.next;
		}
		
		SinglyLinkedListNode node = current.next;
		node.next = head;
		current.next = null;
		
		return node;
	}
	
	private static SinglyLinkedListNode placeLastToFrontUsingTwoPointers(SinglyLinkedListNode head) {

		SinglyLinkedListNode next = head;
		SinglyLinkedListNode prev = null;
		
		if(head == null || head.next == null)
			return head;
		while(next.next!=null) {
			
			prev = next;
			next = next.next;
		}
		
		next.next = head;
		prev.next = null;
		
		return next;
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

		    SinglyLinkedListNode llist1 = placeLastToFront(llist.head);
			//SinglyLinkedListNode llist2 = placeLastToFrontUsingTwoPointers(llist.head);

			printSinglyLinkedList(llist1);
			//printSinglyLinkedList(llist2);
		}


		scanner.close();
	}
	
}
