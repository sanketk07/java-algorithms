/**
 * 
 */
package com.leetcode.easy;

import java.util.Stack;

/**
 * @author sanketkumar
 *
 */
public class ValidParenthesis {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	
	public static void main(String args[]) {
		ValidParenthesis vp = new ValidParenthesis();
		String s = "{{)}";
		boolean flag = vp.isValid(s);
		System.out.println(flag);
	}
}
