package com.dsa.bst;

public class BST13_KthSmallest {

	Node root;
	static int count = 0;

	public static void main(String[] args) {

		BST13_KthSmallest tree = new BST13_KthSmallest();
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
		Node result = findKthSmallest(tree.root,5);
		System.out.println(result.data);
	}

	private static Node findKthSmallest(Node root2, int k) {

		if(root2==null)
			return null;

		Node left = findKthSmallest(root2.left,k);

		if(left!=null)
			return left;
		count++;

		if(count==k)
			return root2;

		return findKthSmallest(root2.right, k);
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
