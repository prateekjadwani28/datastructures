package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT10_RightView {

	Node root;
	static int maxLevel = 0;

	public static void main(String[] args) {

		BT10_RightView tree = new BT10_RightView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before Right View of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Right View of binary tree using Iterative is - ");
		rightViewByIterative(tree.root);
		System.out.println();
		System.out.println("After Right View of binary tree using Recurssion is - ");
		rightViewByRecurssion(tree.root,1);


	}

	private static void rightViewByRecurssion(Node root2, int level) {

		if(root2==null)
			return ;

		if(maxLevel<level) {
			System.out.print(root2.data+" ");
			maxLevel = level;
		}

		rightViewByRecurssion(root2.right, level+1);
		rightViewByRecurssion(root2.left, level+1);

	}

	private static void rightViewByIterative(Node root) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int size = queue.size();

			for(int i=1;i<=size;i++) {
				Node temp = queue.poll();

				if(i==1)
					System.out.print(temp.data+" ");
				if(temp.right!=null)
					queue.add(temp.right);
				if(temp.left!=null)
					queue.add(temp.left);
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
