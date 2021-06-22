package com.dsa.bst;


public class BST04_PredecessorAndSuccessor {

	Node root;

	public static void main(String[] args) {

		BST04_PredecessorAndSuccessor tree = new BST04_PredecessorAndSuccessor();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);


		System.out.println("Binary tree is - ");
		inorderTraversal(tree.root);
		System.out.println();

		Node key = tree.root.left;

		System.out.println("Inorder Successor for "+key.data+" is : ");
		findInorderSuccessor(tree.root,key);
		
	}

	private static void findInorderSuccessor(Node root2,Node key) {

		if(root2==null) {
			System.out.print(-1);
			return;
		}

		if(key.right!=null) {

			Node temp = key.right;
			while(temp.left!=null) {
				temp = temp.left;
			}
			System.out.print(temp.data);
		}
		else {
			Node store = new Node(-1);

			while(root2.data!=key.data) {

				if(key.data <= root2.data) {
					store = root2;
					root2 = root2.left;
				}
				else
					root2 = root2.right;
			}
			System.out.print(store.data);
		}
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
