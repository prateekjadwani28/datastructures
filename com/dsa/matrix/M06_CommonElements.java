package com.dsa.matrix;

import java.util.HashMap;
import java.util.Map;

public class M06_CommonElements {

	public static void main(String[] args) {

		int mat[][] =
		    {
		        { 2, 4, 3, 8, 7 },
		        { 4, 7, 1, 3, 2 },
		        { 3, 5, 2, 1, 3 },
		        { 4, 5, 0, 2, 3 },
		    };
		 
		    findCommon(mat);
	}
	// 2==4 4==2 3==4 8==1 7==2
	private static void findCommon(int[][] mat) {
		
		Map<Integer,Integer> map = new HashMap<>();
		
		System.out.print("The common elements are : ");
		for(int i=0;i<mat.length;i++) {
			
			for(int j=0;j<mat[0].length;j++) {
				
				if(i==0)
					map.put(mat[i][j], 1); 
				
				if(i>0 && map.containsKey(mat[i][j]) && map.get(mat[i][j]) == i) {
					
					map.put(mat[i][j], i + 1);
					
					if (i == mat.length - 1) {
                        System.out.print(mat[i][j] + " ");
                    }
				}
			}
		}
	}

}
