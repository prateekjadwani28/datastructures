package com.dsa.bst;

public class BST22_Siblings {

	Node root;

	public static void main(String[] args) {

		BST22_Siblings tree = new BST22_Siblings();
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
		boolean result = areSiblings(tree.root,6,11);
		System.out.println(result);
	}

	private static boolean areSiblings(Node root, int node1, int node2) {
		
		if(root==null)
			return false;
		if(root.left!=null && root.right!=null) {
			
			int left = root.left.data;
			int right = root.right.data;
			
			if(left == node1 && right == node2)
				return true;
			else if(left == node2 && right == node1)
				return true;
		}
		
		if(root.left!=null)
			return areSiblings(root.left, node1, node2);
		if(root.right!=null)
			return areSiblings(root.right, node1, node2);
		
		return false;
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
