package com.dsa.bst;

class MinMax{
	int min;
	int max;
	boolean isBST;
	int size ;

	MinMax(){
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		isBST = true;
		size = 0;
	}
}
