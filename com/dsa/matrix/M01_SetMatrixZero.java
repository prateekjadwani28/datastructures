package com.dsa.matrix;

import java.util.HashSet;
import java.util.Set;

public class M01_SetMatrixZero {

	public static void main(String[] args) {

		int mat[][] = {{1, 0, 0, 1},
				       {1, 1, 1, 1},
				       {1, 1, 1, 1}};


		modifyMatrixByHashing(mat);
		printMatrix(mat);
	}
	
	private static void modifyMatrixByHashing(int [][] nums) {
		
		int n = nums.length;
		int m = nums[0].length;

		Set<Integer> rows = new HashSet<>();
		Set<Integer> columns = new HashSet<>();

		for(int i = 0; i< n; i++){
			for(int j=0;j<m;j++){
				if(nums[i][j]==0){
				rows.add(i);
				columns.add(j);
				}
			}
		}


		for(int i = 0; i< n; i++){
			for(int j=0;j<m;j++){
				if(rows.contains(i) || columns.contains(j)){
					nums[i][j] =0;
				}
			}
		}

	}
	
	public static void printMatrix(int mat[][]){
        for (int i = 0; i < mat.length; i ++){
            for (int j = 0; j < mat[0].length; j ++){
                System.out.print( mat[i][j] );
            }
                System.out.println("");
        }
    }
      
}
