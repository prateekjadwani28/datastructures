package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BT38_RootLeafSum {

	Node root;

	public static void main(String[] args) {

		
		BT38_RootLeafSum tree = new BT38_RootLeafSum();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.left = new Node(6);

		System.out.println("Binary tree is - ");
		tree.printLevelOrder();
		System.out.println();

		int sum = 14;
		boolean isPathPresent = hasPathSum(tree.root,sum);

		System.out.println("Is path available from root to node "
				+ "with given sum "+sum+" :- "+isPathPresent);
	}

	private static boolean hasPathSum(Node root2, int sum) {
	
		if(root2.left==null && root2.right==null)
			return sum == root2.data;
		
		if(root2.left!=null && hasPathSum(root2.left, sum-root2.data)) 
			return true;
		
		if(root2.right!=null && hasPathSum(root2.right, sum-root2.data)) 
			return true;
		
		return false;
	}

	private void printLevelOrder() {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			System.out.print(temp.data + " ");
			
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
	}

}
