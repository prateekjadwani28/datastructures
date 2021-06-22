package com.dsa.linkedlist;

class LL37_DeleteNodeWithoutHead {
  
    static Node head;
    static class Node {
  
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
  
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
  // 1 --> 2 --> 3 --> 4 --> 5
  
  /* node = 3
   * temp = 4
   * 1 --> 2 --> 4 --> 4 --> 5
   * 1 --> 2 --> 4  --> 5
   */
    
    void deleteNode(Node node)
    {
        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
        System.gc();
    }
  
    // Driver code
    public static void main(String[] args)
    {
    	LL37_DeleteNodeWithoutHead list = new LL37_DeleteNodeWithoutHead();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
  
        System.out.println("Before Deleting ");
        list.printList(head);
  
        /* I m deleting the head itself.
         You can check for more cases */
        list.deleteNode(head.next.next);
        System.out.println("");
        System.out.println("After deleting ");
        list.printList(head);
    }
}