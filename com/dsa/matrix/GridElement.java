package com.dsa.matrix;

public class GridElement implements Comparable<GridElement>{

	@Override
	public String toString() {
		return "GridElement [rowIndex=" + rowIndex + ", columnIndex=" + columnIndex + ", data=" + data + "]";
	}
	int rowIndex;
	int columnIndex;
	int data;
	public GridElement(int rowIndex, int columnIndex, int data) {
		super();
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.data = data;
	}
	public int compareTo(GridElement obj) {
		return this.data - obj.data; // for largest flip the condition to get the descending ordering (obj.data - this.data)
	}
}
