package com.dsa.bst;

public class BST24_SumOfLeafNodes {

	Node root;
	static int sum = 0;
	
	public static void main(String[] args) {

		BST24_SumOfLeafNodes tree = new BST24_SumOfLeafNodes();
		tree.root = new Node(6);
		tree.root.left = new Node(4);
		tree.root.right = new Node(9);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(11);

		System.out.println("Binary tree is - ");
		inorderTraversal(tree.root);
		System.out.println();
		findSum(tree.root);
		System.out.println(sum);
	}

	private static void findSum(Node root) {
		if(root==null)
			return;
		
		if(root.left==null && root.right==null)
			sum += root.data;
		findSum(root.left);
		findSum(root.right);
		
		return;
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
