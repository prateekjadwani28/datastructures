package com.dsa.linkedlist;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.dsa.linkedlist.LL10_AddTwoNumbers.SinglyLinkedListNode;


public class LL35_LastNodeFromEnd {

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

	// 1 --> 2 --> 3 --> 4 --> 5  --- 2
	static SinglyLinkedListNode endNode(SinglyLinkedListNode head, int index) {
		
		
		SinglyLinkedListNode anchor = head;
		SinglyLinkedListNode explorer = head;
		
		while(explorer!=null) {
			
			if(index>0) {
				
				explorer = explorer.next;
				index--;
			}
			else {
				
				explorer = explorer.next;
				anchor = anchor.next;
			}
		}
		
		return anchor;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int tests = scanner.nextInt();
		for (int testsItr = 0; testsItr < tests; testsItr++) {
			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();

			for (int i = 0; i < llistCount; i++) {
				int llistItem = scanner.nextInt();

				llist.insertNode(llistItem);
			}
			SinglyLinkedListNode llist1 = endNode(llist.head,3);

			System.out.println(llist1.data);
			//printSinglyLinkedList(llist1);
		}


		scanner.close();
	}

}
