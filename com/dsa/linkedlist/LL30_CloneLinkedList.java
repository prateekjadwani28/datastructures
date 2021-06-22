package com.dsa.linkedlist;

import java.io.*;
import java.util.*;


public class LL30_CloneLinkedList {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;
		public SinglyLinkedListNode random;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.random = null;
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
		
		public void insertRandomNode(SinglyLinkedListNode node, int data) {
			
			SinglyLinkedListNode temp = this.head;
			
			while(temp!=null) {
				
				if(temp.data == data) {
					node.random = temp;
					break;
				}
				temp = temp.next;
			}
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {


		SinglyLinkedListNode current = node;

		if(current == null)
			System.out.println("List is empty");
		else {
			while(current!=null) {
				System.out.print(current.data+" - "+current.random.data+" ");
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
	static SinglyLinkedListNode cloneLinkedList(SinglyLinkedListNode head) {
		
		// 1. Add a copy node to next of its own node
		
		SinglyLinkedListNode dummy = null;
		SinglyLinkedListNode temp = null;
		SinglyLinkedListNode current = head;
		
		while(current!=null) {
			temp = current.next;
			dummy = new SinglyLinkedListNode(current.data);
			current.next = dummy; 
			dummy.next = temp;
			current = temp;
		}
		
		current = head;
		
		// 2. Copy the random pointers to the cloned LL 
		 
		while(current!=null && current.next!=null) {
			
			if (current.random != null) {
				current.next.random = current.random.next;
	            }
			current = current.next.next;
		}
		
		// 3. Separate out both the lists - cloned AND original 
		
		current = head;
		SinglyLinkedListNode newHead = new SinglyLinkedListNode(0);
		SinglyLinkedListNode copy = newHead;
		
		while(current!=null && current.next!=null) {
			
			SinglyLinkedListNode node = current.next.next;
			copy.next = current.next;
			copy = copy.next;
			current.next = node;
			current = node;
		}
		
		return newHead.next;
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
			
			SinglyLinkedListNode randomNode = llist.head;
			
			while(randomNode!=null) {
				llist.insertRandomNode(randomNode, scanner.nextInt());
				randomNode = randomNode.next;
			}

			SinglyLinkedListNode llist1 = cloneLinkedList(llist.head);

			printSinglyLinkedList(llist1);
		}


		scanner.close();
	}
}
