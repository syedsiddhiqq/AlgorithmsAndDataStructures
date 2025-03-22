package LeetCode.datastructures.stacks;

import java.util.Stack;

/**
 * @author SyedAli
 * @createdAt 06-03-2023, Monday, 09:14
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/")) {
                int a = Integer.parseInt(stack.pop()), b = Integer.parseInt(stack.pop());
                switch (token) {
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                    default:
                        stack.push(String.valueOf(a - b));
                }
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(reversePolishNotation.evalRPN(tokens));
    }
}
