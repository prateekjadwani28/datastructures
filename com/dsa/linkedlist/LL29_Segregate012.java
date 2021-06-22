package com.dsa.linkedlist;

import java.io.*;
import java.util.*;


public class LL29_Segregate012 {

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
	static SinglyLinkedListNode segregatationOfZerosOnesTwos(SinglyLinkedListNode head) {

		SinglyLinkedListNode curr = head;
		int zero=0;
		int one=0;
		int two=0;

		while(curr != null) {
			if(curr.data == 0) {
				zero++;
			}
			else if(curr.data == 1) {
				one++;
			}
			else if(curr.data == 2) {
				two++;
			}
			curr = curr.next;
		}

		SinglyLinkedListNode p1= head;

		while(p1 != null) {
			if(zero > 0) {
				p1.data = 0;
				zero--;
			}
			else if(one > 0) {
				p1.data = 1;
				one--;

			}
			else if(two > 0) {
				p1.data = 2;
				two--;
			}

			p1 = p1.next;
		}

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

			SinglyLinkedListNode llist1 = segregatationOfZerosOnesTwos(llist.head);

			printSinglyLinkedList(llist1);
		}


		scanner.close();
	}
}
