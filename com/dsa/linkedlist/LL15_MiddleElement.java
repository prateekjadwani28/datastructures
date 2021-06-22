package com.dsa.linkedlist;

import java.io.*;
import java.util.*;


public class LL15_MiddleElement {

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
				System.out.println(current.data);
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
	static SinglyLinkedListNode middleElement(SinglyLinkedListNode head) {

		SinglyLinkedListNode slow = head;
		SinglyLinkedListNode fast = head;

		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}

			return slow;

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

			SinglyLinkedListNode llist1 = middleElement(llist.head);

			System.out.println(llist1.data);
			//printSinglyLinkedList(llist1);
		}


		scanner.close();
	}
}
