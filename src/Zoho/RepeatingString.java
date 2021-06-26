package Zoho;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 23/05/2021, Sunday, 16:35
 */
public class RepeatingString {
	static Scanner fs = new Scanner(System.in);

	/**
	 * To reverse a string..
	 *
	 * @param inputStr
	 * @return
	 */
	public static String reverse(String inputStr) {
		String reversedStr = "";
		for (int i = inputStr.length() - 1; i >= 0; i--) {
			reversedStr += inputStr.charAt(i);
		}
		return reversedStr;
	}

	public static void pushIntoStack(String inputStr, Stack<Character> stack) {
		for (int i = 0; i < inputStr.length(); i++) {
			stack.push(inputStr.charAt(i));
		}
	}

	public static void main(String[] args) {
		char[] str = fs.next().toCharArray();
		int count = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ')') {

				String substr = "";
				while (stack.peek() != '(') {
					substr += stack.pop();
				}
				substr = reverse(substr);

				// to remove the open parenthesis...
				stack.pop();

				// To extract the count...
				StringBuilder countStr = new StringBuilder();
				i = i + 2;
				while (str[i] != '}') {
					countStr.append(str[i]);
					i++;
				}
				count = Integer.parseInt(countStr.toString());

				String finalStr = "";
				for (int k = 0; k < count; k++) {
					finalStr += substr;
				}
				pushIntoStack(finalStr, stack);
			} else {
				stack.push(str[i]);
			}
		}

		StringBuilder result = new StringBuilder();

		stack.forEach(result::append);
		System.out.println(result.toString());
	}
}
