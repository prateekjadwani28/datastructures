package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT09_LeftView {

	Node root;
	static int maxLevel = 0;

	public static void main(String[] args) {

		BT09_LeftView tree = new BT09_LeftView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before Left View of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Left View of binary tree using Iterative is - ");
		leftViewByIterative(tree.root);
		System.out.println();
		System.out.println("After Left View of binary tree using Recurssion is - ");
		leftViewByRecurssion(tree.root,1);

	}

	/*
	 * we will be checking this by vertical levels. so in every level, we have elements and the first element in that level will
	 * get printed as left view of that particular level. On contrary, right view will be executed.
	 * 
	 * */
	private static void leftViewByRecurssion(Node root2, int level) {

		if(root2==null)
			return ;

		if(maxLevel<level) {
			System.out.print(root2.data+" ");
			maxLevel = level;
		}

		leftViewByRecurssion(root2.left, level+1);
		leftViewByRecurssion(root2.right, level+1);

	}

	private static void leftViewByIterative(Node root) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int size = queue.size();

			for(int i=1;i<=size;i++) {
				Node temp = queue.poll();

				if(i==1)
					System.out.print(temp.data+" ");
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
		}
	}

	private  void printLevelOrder() {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {

			Node temp = queue.poll();
			System.out.print(temp.data + " ");

			if(null!=temp.left)
				queue.add(temp.left);
			if(null!=temp.right)
				queue.add(temp.right);
		}

	}
}
