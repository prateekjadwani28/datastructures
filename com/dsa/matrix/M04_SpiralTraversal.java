package com.dsa.matrix;

public class M04_SpiralTraversal {

	public static void main(String[] args) {
		
		int mat[][] = {
	            { 1, 2, 3, 4 },
	            { 5, 6, 7, 8 },
	            { 9, 10, 11, 12 },
	            { 13, 14, 15, 16 }};
		
		spiralTraversal(mat);
	}

	private static void spiralTraversal(int[][] mat) {

		int top = 0;
		int bottom = mat.length - 1;
		int left = 0;
		int right = mat.length - 1;
		
		int dir = 0;
		System.out.print("Spiral Traversal : " );
		while(left<=right && top<=bottom) {
			
			if(dir == 0) {
				for(int i=left; i<=right;i++)
					System.out.print(mat[top][i] + " ");
				top++;
			}
			
			else if(dir == 1) {
				for(int i=top; i<=bottom;i++)
					System.out.print(mat[i][right] + " ");
				right--;
			}
			
			if(dir == 2) {
				for(int i=right; i>=left;i--)
					System.out.print(mat[bottom][i] + " ");
				bottom--;
			}
			
			if(dir == 3) {
				for(int i=bottom; i>=top;i--)
					System.out.print(mat[i][left] + " ");
				left++;
			}
			
			dir = (dir+1)%4;
		}
	}

}
