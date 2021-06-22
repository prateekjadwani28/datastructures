package com.dsa.linkedlist;

import java.io.*;
import java.util.*;


public class LL34_SegregateEvenOdd {

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
	static SinglyLinkedListNode segregatationOfEvenOdd(SinglyLinkedListNode head) {

		SinglyLinkedListNode evenBegin = null;
		SinglyLinkedListNode evenEnd = null;
		SinglyLinkedListNode oddBegin = null;
		SinglyLinkedListNode oddEnd = null;

		SinglyLinkedListNode node = head;


		// 2 --> 5 --> 1 --> 8 -->3
		// 2 --> 8  5 -->1 -->3
		// 2 --> 8--> 5 -->`1 --> 3
		while(node!=null) {

			int element = node.data;

			if(element%2==0) {

				// this is to create a node which will have first even node
				if(evenBegin == null) {
					evenBegin = node;
					evenEnd = evenBegin;

				}// else then it will link up all the even nodes 
				else {
					evenEnd.next = node;
					evenEnd = evenEnd.next;
				}
			}
			// this is to create a node which will have first odd node
			else {

				if(oddBegin == null) {
					oddBegin = node;
					oddEnd = oddBegin;

				}
				//// else then it will link up all the odd nodes 
				else {
					oddEnd.next = node;
					oddEnd = oddEnd.next;
				}
			}
			node = node.next;
		}

		evenEnd.next = oddBegin;
		oddEnd.next = null;

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

			SinglyLinkedListNode llist1 = segregatationOfEvenOdd(llist.head);

			printSinglyLinkedList(llist1);
		}


		scanner.close();
	}
}
