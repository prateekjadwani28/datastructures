package com.dsa.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

public class MS20_RottenOranges {

	public static void main(String[] args) {
		int[][] orangeGrid =  {
				{2,1,1},
				{1,1,0},
				{0,1,1}
		}; 

		int time = findTimeForRottenOranges(orangeGrid);
		System.out.println("Time taken to rot other oranges is " +time);

	}

	private static int findTimeForRottenOranges(int[][] orangeGrid) {

		Queue<Pair> queue = new LinkedList<>();
		int total = 0;
		int rotten = 0;
		int time = 0;

		for(int i=0;i<orangeGrid.length;i++) {
			for(int j=0; j<orangeGrid[0].length;j++) {
				if(orangeGrid[i][j] == 1 || orangeGrid[i][j] == 2)
					total++;
				if(orangeGrid[i][j] == 2)
					queue.add(new Pair(i,j));
			}
		}

		if(total == 0)
			return 0;

		while(!queue.isEmpty()) {

			rotten = rotten + queue.size();

			if(rotten == total)
				return time;

			time++;

			for(int i=0; i<queue.size();i++) {
				Pair p = queue.poll();
				
				if(p.row + 1 < orangeGrid.length && orangeGrid[p.row + 1][p.column] == 1) {
					orangeGrid[p.row + 1][p.column] = 2;
					queue.add(new Pair(p.row + 1 , p.column));
				}
				
				if(p.row - 1 > 0 && orangeGrid[p.row - 1][p.column] == 1) {
					orangeGrid[p.row - 1][p.column] = 2;
					queue.add(new Pair(p.row - 1 , p.column));
				}
				
				if(p.column + 1 < orangeGrid.length && orangeGrid[p.row][p.column + 1] == 1) {
					orangeGrid[p.row][p.column + 1] = 2;
					queue.add(new Pair(p.row , p.column + 1));
				}
				
				if(p.column - 1 > 0 && orangeGrid[p.row][p.column - 1] == 1) {
					orangeGrid[p.row][p.column - 1] = 2;
					queue.add(new Pair(p.row , p.column - 1));
				}
			}
		}
		return -1;
	}
}

class Pair{

	int row;
	int column;

	Pair (int row, int column){
		this.row = row;
		this.column = column;
	}
}
