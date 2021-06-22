package com.dsa.bst;

public class BST23_Cousins {

	Node root;

	public static void main(String[] args) {

		BST23_Cousins tree = new BST23_Cousins();
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
		boolean result = areCousins(tree.root,tree.root.left.right,tree.root.left.left);
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

	private static boolean areCousins(Node root, Node node1, Node node2) {
		
		int level1 = findLevel(root,node1,1);
		int level2 = findLevel(root,node2,1);
		
		if(level1==level2)
			return !areSiblings(root, node1.data, node2.data);
		return false;
		
	}
	private static int findLevel(Node root,Node node, int level) {
		
		if(root==null)
			return 0;
		
		if(node.data == root.data)
			return level;
		
		if(node.data < root.data) 
			return findLevel(root.left, node, level+1);

		else 
			return findLevel(root.right, node, level+1);
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
