package com.dsa.miscellaneous;

public class MS19_FindIntersectionPoint {

	public static void main(String[] args) {
		// list 1
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);
        // list 2
        Node n2 = new Node(10);
        n2.next = new Node(9);
        n2.next.next = new Node(8);
        n2.next.next.next = n1.next.next.next;
        Print(n1);
        Print(n2);
        System.out.println("Intersection Point is : "+MegeNode(n1, n2).data);

	}
	
	 private static Node MegeNode(Node headA, Node headB) {
		
		 if(headA == null || headB == null)
			 return null;
		 
		 Node dummyA = headA;
		 Node dummyB = headB;
		 while(dummyA!=dummyB) {
			 
			 if(dummyA!=null)
				 dummyA = dummyA.next;
			 else
				 dummyA = headB;
			 
			 if(dummyB!=null)
				 dummyB = dummyB.next;
			 else
				 dummyB = headA;
		 }
		 
		 return dummyA;
	}

	// function to print the list
    public static void Print(Node n)
    {
        Node cur = n;
        while (cur != null) {
            System.out.print(cur.data + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

}

class Node {
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
