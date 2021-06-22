package com.dsa.linkedlist;

import java.io.*;
import java.util.*;


public class LL18_PalindromeCheck {

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
	static boolean isPalindromeByStack(SinglyLinkedListNode head) {


		SinglyLinkedListNode node = head;

		Stack<SinglyLinkedListNode> stack = new Stack<>();
		while(node!=null) {
			stack.push(node);
			node = node.next;
		}

		boolean flag = true;

		while(head!=null) {
			SinglyLinkedListNode current = stack.pop();
			if(current.data==head.data)
				flag = true;
			else {
				flag = false;
				break;
			}
			head = head.next;
		}
		
		return flag;
	}
// 1 2 3 2 1 --> 1 2 3  1 2 3 
	static boolean isPalindrome(SinglyLinkedListNode head) {
		
		SinglyLinkedListNode slow = head;
		SinglyLinkedListNode fast = head;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			
		}
		
		SinglyLinkedListNode node = slow;
		SinglyLinkedListNode newHead = null;
		
		while(node!=null) {
		
			SinglyLinkedListNode next = node.next;
			node.next = newHead;
			newHead = node;
			node = next;
		}
		
		
		
		SinglyLinkedListNode dummy = head;
		boolean flag = true;

		while(newHead!=null) {
			if(newHead.data != dummy.data) {
				flag = false;
				break;
			}
			newHead = newHead.next;
			dummy = dummy.next;
		}
		return flag;
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

			boolean result = isPalindromeByStack(llist.head);
			boolean output = isPalindrome(llist.head);

			System.out.println(result);
			//printSinglyLinkedList(llist1);
		}


		scanner.close();
	}
}
