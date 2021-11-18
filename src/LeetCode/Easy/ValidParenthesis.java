package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Syed Ali.
 * @createdAt 08/10/2021, Friday, 12:01
 */
public class ValidParenthesis {

	public static boolean isValid(String s) {
		char[] str = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char ch : str) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (ch == ')' && stack.peek().equals('(')) {
					stack.pop();
				} else if (ch == ']' && stack.peek().equals('[')) {
					stack.pop();
				} else if (ch == '}' && stack.peek().equals('{')) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("{[]}"));
	}
}
