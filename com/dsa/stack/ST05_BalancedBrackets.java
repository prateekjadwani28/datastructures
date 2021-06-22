package com.dsa.stack;

import java.util.Stack;

public class ST05_BalancedBrackets {

	public static void main(String[] args) {

		String str = "{[()]}[{)]";
		System.out.println(str);
		System.out.println("Is brackets balanced ? " +isBalanced(str));
	}

	private static boolean isBalanced(String str) {

		Stack<Character> stack = new Stack<>();

		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch == '{' || ch == '[' || ch == '(')
				stack.push(ch);
			else {

				if(ch == '}' && stack.peek()=='{')
					stack.pop();
				else if(ch == ']' && stack.peek()=='[')
					stack.pop();
				else if(ch == ')' && stack.peek()=='(')
					stack.pop();
				else
					return false;
			}
		}
		return true;
	}
}
