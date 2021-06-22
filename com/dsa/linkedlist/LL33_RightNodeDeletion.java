package com.dsa.linkedlist;

import java.io.*;
import java.util.*;

import com.dsa.linkedlist.LL01_ReverseLinkedList.SinglyLinkedListNode;



public class LL33_RightNodeDeletion {

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

	//  1-> 2 -> 3 -> 4
	static SinglyLinkedListNode deleteRightNode(SinglyLinkedListNode head) {
		 head = reverseList(head);
		 
		 SinglyLinkedListNode current = head;
		 SinglyLinkedListNode maxNode = head;
		 SinglyLinkedListNode temp;
		 
		 while(current != null && current.next != null) {
			 if(current.next.data < maxNode.data) {
				 temp = current.next;
				 current.next = temp.next;
			 }
			 else {
				 current = current.next;
				 maxNode = current;
			 }
		 }
		 
		 head = reverseList(head);
		 
		 return head;
	}
	
	static SinglyLinkedListNode reverseList(SinglyLinkedListNode head) {

		SinglyLinkedListNode newHead = null;
		SinglyLinkedListNode next = null;
		while(head!=null) {
			
		    next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
			return newHead;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		SinglyLinkedList llist1 = new SinglyLinkedList();

		int llistCount1 = scanner.nextInt();

		for (int i = 0; i < llistCount1; i++) {
			int llistItem = scanner.nextInt();
			llist1.insertNode(llistItem);
		}


		SinglyLinkedListNode node = deleteRightNode(llist1.head);
		printSinglyLinkedList(node);

		scanner.close();
	}

}
