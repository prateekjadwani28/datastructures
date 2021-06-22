package com.dsa.linkedlist;

import java.io.*;
import java.util.*;


public class LL19_DeletionInCircularLL {

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
			SinglyLinkedListNode fast = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = fast;
			} else {
				this.tail.next = fast;
			}

			this.tail = fast;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode head) throws IOException {


		SinglyLinkedListNode slow = head;

		if(slow == null)
			System.out.println("List is empty");
		else {
			while(slow!=null && slow.next!=head) {
				System.out.print(slow.data+" ");
				slow = slow.next;
			}
			System.out.print(slow.data+" ");
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
	 * 1 -> 2 -> 3 -> 4 -> 1
	 */
	private static SinglyLinkedListNode deleteFromCircularLinkedList(SinglyLinkedListNode head, int data) {

		SinglyLinkedListNode dummy = head;

		while(dummy!=null && dummy.next!=head) {
			dummy = dummy.next;
		}

		
		// if there is only one node 
		
		if(head!=null && head.next==head) {
			head = null;
			return head;
		}
		// deletion of first node
		if(head!=null && head.data == data) {
			head = head.next;
			dummy.next = head;
			return head;
		}

		// deletion of last node
		else if(dummy!=null && dummy.data==data) {
			SinglyLinkedListNode node = head;

			while(node!=null && node.next!=dummy) {
				node = node.next;
			}
			node.next = head;
		}

		// deletion of any middle nodes
		else {

			SinglyLinkedListNode current = head;

			while(current!=null && current.next!=null) {

				if(current.next.data==data) {
					current.next = current.next.next;
					break;
				}
				current = current.next;
			}
		}
		
		return head;
	}


	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			int index = 0;
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
			SinglyLinkedListNode temp = llist.head;

			for (int i = 0; i < llistCount; i++) {
				if (i == index) {
					extra = temp;
				}

				if (i != llistCount-1) {
					temp = temp.next;
				}
			}

			temp.next = extra;

			SinglyLinkedListNode result = deleteFromCircularLinkedList(llist.head,1);
			printSinglyLinkedList(result);
		}
		scanner.close();
	}
}