package com.dsa.bst;



public class BST26_InsertNode {

	Node root;

	public static void main(String[] args) {



		BST26_InsertNode tree = new BST26_InsertNode();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(13);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		tree.root.right.right = new Node(15);


		System.out.print("Binary tree is - ");
		inorderTraversal(tree.root);
		System.out.println();
		int k = 7;
		insertNode(tree.root,k);
		System.out.print("After insertion Binary tree is - ");
		inorderTraversal(tree.root);

	}

	private static Node insertNode(Node root2,int value) {

		if(root2==null) {
			return new Node(value);
		}

		if(root2.data > value) 
			root2.left = insertNode(root2.left, value);

		else 
			root2.right = insertNode(root2.right, value);

		return root2;
	}


	private static void inorderTraversal( Node root2) {
		if(root2==null)
			return;
		inorderTraversal(root2.left);
		System.out.print(root2.data+" ");
		inorderTraversal(root2.right);

	}
}
