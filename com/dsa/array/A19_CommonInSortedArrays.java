package com.dsa.array;

public class A19_CommonInSortedArrays {

	public static void main(String[] args) {
		/*int [] a = {3,3,3,3,3,3};
		int [] b = {3,3,3,3,};
		int [] c = {3,3,3};*/

		int [] a = {1,5,10,20,20,40,80};
		int [] b = {6,7,20,80,100};
		int [] c = {3,4,15,20,30,70,80,120};

		findCommonElements(a,b,c);

	}

	private static void findCommonElements(int[] a, int[] b, int[] c) {

		int i=0,j=0,k=0;

		while(i<a.length && j<b.length && k<c.length) {

			if(a[i]<b[j] && a[i]<c[k])
				i++;
			else if(b[j]<a[i] && b[j]<c[k])
				j++;
			else if(c[k]<a[i] && c[k]<b[j])
				k++;
			else {
				System.out.print(a[i]+" ");
				i++;
				j++;
				k++;
			}
		}
	}
}
