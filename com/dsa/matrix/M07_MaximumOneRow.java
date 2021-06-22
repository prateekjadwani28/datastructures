package com.dsa.matrix;

public class M07_MaximumOneRow {

	public static void main(String[] args) {

		int[][] mat =
			{
					{ 0, 0, 0, 1, 1 },
					{ 0, 0, 1, 1, 1 },
					{ 0, 0, 0, 0, 0 },
					{ 0, 1, 1, 1, 1 },
					{ 0, 0, 0, 0, 1 }
			};

		findMaximumOneRow(mat);
	}

	private static void findMaximumOneRow(int[][] mat) {

		int row = -1;
		int i = 0, j = mat.length - 1;

		while(i<mat.length && j>=0) {
			if(mat[i][j] == 1) {
				j--;
				row = i;
			}
			else 
				i++;
		}
		System.out.print("The maximum 1's are present in the row : " + row);
	}
}
