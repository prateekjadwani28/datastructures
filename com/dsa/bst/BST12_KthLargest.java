package com.dsa.bst;

public class BST12_KthLargest {

	Node root;
	static int count = 0;

	public static void main(String[] args) {

		BST12_KthLargest tree = new BST12_KthLargest();
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
		Node result = findKthLargest(tree.root,3);
		System.out.println(result.data);
	}

	private static Node findKthLargest(Node root2, int k) {

		if(root2==null)
			return null;

		Node right = findKthLargest(root2.right,k);

		if(right!=null)
			return right;
		count++;

		if(count==k)
			return root2;

		return findKthLargest(root2.left, k);
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
