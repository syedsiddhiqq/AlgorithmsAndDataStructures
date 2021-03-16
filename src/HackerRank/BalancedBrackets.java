package HackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Syed Ali.
 * @createdAt 14/03/2021, Sunday, 18:46
 */
public class BalancedBrackets {

	static String isBalanced(String s){
		char[] charArr = s.toCharArray();
		Stack<Character> charStack = new Stack<>();
		for (char c : charArr) {
			if (c == '(' || c == '{' || c == '[') {
				charStack.push(c);
			} else if(!charStack.isEmpty()){
				if (c == ')' && charStack.peek().equals('(')) {
					charStack.pop();
				} else if (c == '}' && charStack.peek().equals('{')) {
					charStack.pop();
				} else if (c == ']' && charStack.peek().equals('[')) {
					charStack.pop();
				} else {
					return "NO";
				}
			}else{
				return "NO";
			}
		}
		return "YES";
	}

	public static void main(String[] args) throws IOException {
		System.out.println(isBalanced("}][}}(}][))]"));
	}
}
