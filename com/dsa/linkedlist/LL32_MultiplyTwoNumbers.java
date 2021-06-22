package com.dsa.linkedlist;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.dsa.linkedlist.LL01_ReverseLinkedList.SinglyLinkedListNode;


public class LL32_MultiplyTwoNumbers {

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

	//  1->2->3  3->2->1
	static void multiplyNumbers(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		int num1 = 0;
		int num2 = 0;

		while(head1!=null) {

			num1 = num1*10 + head1.data;
			head1= head1.next;
		}

		while(head2!=null) {

			num2 = num2*10 + head2.data;
			head2 = head2.next;
		}
		
		System.out.println(num1 * num2 );
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		SinglyLinkedList llist1 = new SinglyLinkedList();
		SinglyLinkedList llist2 = new SinglyLinkedList();

		int llistCount1 = scanner.nextInt();

		for (int i = 0; i < llistCount1; i++) {
			int llistItem = scanner.nextInt();
			llist1.insertNode(llistItem);
		}

		int llistCount2 = scanner.nextInt();

		for (int i = 0; i < llistCount2; i++) {
			int llistItem = scanner.nextInt();
			llist2.insertNode(llistItem);
		}


		multiplyNumbers(llist1.head,llist2.head);

		scanner.close();
	}

}
