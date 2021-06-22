package com.leet.array;

import java.io.*;
import java.util.*;


public class A12_DetectCycle {

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

	public static void printSinglyLinkedList(SinglyLinkedListNode fast) throws IOException {


		SinglyLinkedListNode slow = fast;

		if(slow == null)
			System.out.println("List is empty");
		else {
			while(slow!=null) {
				System.out.print(slow.data+" ");
				slow = slow.next;
			}
		}

	}

	private static boolean detectLoop(SinglyLinkedListNode head) {

		SinglyLinkedListNode slow = head;
		SinglyLinkedListNode fast = head;
		
		while(slow!=null && fast!=null && fast.next!=null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow==fast)
				return true;
		}
		
		return false;
	}	

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = scanner.nextInt();
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

            boolean result = detectLoop(llist.head);
            System.out.println(result);
        }


        scanner.close();
    }

}
