package com.dsa.matrix;

public class M03_RotateMatrix {

	public static void main(String[] args) {

        /* Test Case 1
        int mat[][] = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 }};
            */
        // Tese Case 2
         int mat[][] = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
         
        rotate(mat);
        displayMatrix(mat);
        
	}

	private static void rotate(int[][] mat) {

		transpose(mat);
        reflect(mat);
	}

	
	 /* Transpose of a matrix means row will become column and column will become row*/
	public static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
    
	// Rotate means 
    public static void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
        	int x = 0;
        	int y = n-1;
        	while(x<y) {
        		int temp = matrix[i][x];
        		matrix[i][x] = matrix[i][y];
        		matrix[i][y] = temp;
        		
        		x++;
        		y--;
        	}
        }
    }
    
 // Function to print the matrix
    private static void displayMatrix(int mat[][])
    {
    	int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(
                    " " + mat[i][j]);
 
            System.out.print("\n");
        }
        System.out.print("\n");
    }
 

}
