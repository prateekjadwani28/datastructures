package com.dsa.miscellaneous;

import java.util.Arrays;

public class MS10_AlternateAlphaNumeric {

	public static void main(String[] args) {
		
		String s = "ab12dc34";
		alternateAplphaNumeric(s);
	}

	private static void alternateAplphaNumeric(String s) {
		
		int left = 0;
		int right = s.length() - 1;
		
		char ch[] = s.toCharArray();
		while(left<right) {
			
			if(ch[left] > 96 && ch[left] < 123)
				left++;
			else if(ch[right] > 47 && ch[right] < 58)
				right--;
			else {
				char temp = ch[left];
				ch[left] = ch[right];
				ch[right] = temp;
				left++;
				right--;
			}
 		}
		
		System.out.println("Segregation : "+Arrays.toString(ch));
		Arrays.sort(ch,left,ch.length-1);
		Arrays.sort(ch,0,left);
		
		for(int i = 1;i<s.length()-1;i=i+2) {
			
			char temp = ch[left];
			ch[left] = ch[i];
			ch[i] = temp;
			left++;
		}
		System.out.println("Alternate : "+String.valueOf(ch));
	}
}
