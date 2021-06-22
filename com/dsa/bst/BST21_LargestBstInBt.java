package com.dsa.bst;

public class BST21_LargestBstInBt {
	Node root;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST21_LargestBstInBt tree =  new BST21_LargestBstInBt();
		tree.root = new Node(25);
		tree.root.left = new Node(18);
		tree.root.left.left = new Node(19);
		tree.root.left.right = new Node(20);
		tree.root.left.left.right = new Node(15);
		tree.root.left.right.left = new Node(18);
		tree.root.left.right.right = new Node(25);
		tree.root.right = new Node(50);
		tree.root.right.left = new Node(35);
		tree.root.right.right = new Node(60);
		tree.root.right.left.left = new Node(20);
		tree.root.right.left.right = new Node(40);
		tree.root.right.left.left.right = new Node(25);
		tree.root.right.right.left = new Node(55);
		tree.root.right.right.right = new Node(70);
		int size = largestBST(tree.root);
		System.out.println("Size of largest BST is : " + size);
	}

	private static int largestBST(Node root2) {
		MinMax obj = largestBSTUtil(root2);
		return obj.size;
	}

	private static MinMax largestBSTUtil(Node root2) {

		if(root2==null) 
			return new MinMax();


		MinMax left = largestBSTUtil(root2.left);
		MinMax right = largestBSTUtil(root2.right);

		MinMax m = new MinMax();

		//if either of left or right subtree says its not BST or the data
		//of this node is not greater/equal than max of left and less than min of right
		//then subtree with this node as root will not be BST. 
		//Return false and max size of left and right subtree to parent
		if(left.isBST == false || right.isBST==false || 
				(left.max>root2.data || right.min<=root2.data)) {

			m.isBST = false;
			m.size = Math.max(left.size, right.size);
			return m;
		}

		m.isBST = true;
		m.size = left.size + right.size + 1;

		if(root2.left!=null)
			m.min = left.min;
		else
			m.min = root2.data;

		if(root2.right!=null)
			m.max = right.max;
		else
			m.max = root2.data;

		return m;

	}

}
