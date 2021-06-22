package com.dsa.bst;

public class BST16_CountNodesInRange {

	Node root;
	
	public static void main(String[] args) {

		BST16_CountNodesInRange tree = new BST16_CountNodesInRange();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(13);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		tree.root.right.right = new Node(15);

		System.out.println("Binary tree is - ");
		inorderTraversal(tree.root);
		System.out.println();
		int count = countNodes(tree.root,5,13);
		System.out.println(count);
	}

	private static int countNodes(Node root2, int low,int high) {
		
		if(root2==null)
			return 0;
		
		if(low<=root2.data && root2.data<=high) {
			return 1 + countNodes(root2.left,low,high) + countNodes(root2.right, low, high);
		}
		
		else if(root2.data<low)
			return countNodes(root2.right, low, high);
		else 
			return countNodes(root2.left, low, high);
		
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
