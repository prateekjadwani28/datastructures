package com.dsa.linkedlist;

import java.io.*;
import java.util.*;


public class LL02_ReverseInGroup {
	
	static int len = 0;

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
	
	static SinglyLinkedListNode reverseInGroupsUtil(SinglyLinkedListNode head, int k) {
		
		SinglyLinkedListNode current = head;
		while(current!=null) {
			current = current.next;
			len++;
		}
		
		SinglyLinkedListNode node = reverseInGroups(head,k,len);
		return node;
	}
	static SinglyLinkedListNode reverseInGroups(SinglyLinkedListNode head, int k, int len) {

		SinglyLinkedListNode current = head;
		SinglyLinkedListNode next = null;
		SinglyLinkedListNode newHead = null;


		int count = 0;
		while(count<k && current!=null) {

			next = current.next;
			current.next = newHead;
			newHead = current;
			current = next;
			count++;
			len--;

		}
		if(next!=null && len/k > 0)
			head.next = reverseInGroups(next,k,len);
		else
			head.next = next;

		return newHead;

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

			SinglyLinkedListNode llist1 = reverseInGroupsUtil(llist.head,5);

			printSinglyLinkedList(llist1);
		}


		scanner.close();
	}
}
