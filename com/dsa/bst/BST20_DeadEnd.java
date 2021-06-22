package com.dsa.bst;

public class BST20_DeadEnd {

	Node root;
	static boolean flag;
	static int min = Integer.MIN_VALUE;
	static int max = Integer.MAX_VALUE;

	public static void main(String[] args) {

		BST20_DeadEnd tree = new BST20_DeadEnd();
		tree.root = new Node(25);
		tree.root.left = new Node(18);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(17);
		tree.root.left.right = new Node(20);
		tree.root.left.right.left = new Node(19);
		tree.root.right.right = new Node(35);

		System.out.println("Binary tree is - ");
		inorderTraversal(tree.root);
		System.out.println();
		checkDeadEnd(tree.root,min,max);
		System.out.println(flag);
	}

	// Dead end - All leaf nodes where insertion is not possible 
	private static void checkDeadEnd(Node root,int min,int max) {

		if(root==null)
			return;
		
		if(flag)
			return;
		
		if(root.left == null && root.right == null) {
			if(min == max)
				flag = true;
			return;
		}
		checkDeadEnd(root.left,min,root.data-1);
		checkDeadEnd(root.right,root.data+1,max);
		
		return ;
	}

	private static  void inorderTraversal(Node root) {

		if(root == null)
			return;

		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);

		return;
	}

}
