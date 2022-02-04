package LeetCode.Greedy;

import java.util.Stack;

/**
 * @author Syed Ali.
 * @createdAt 19/11/2021, Friday, 23:18
 */
public class RemoveDuplicate {
	private static void p(String msg, Object value){
		System.out.println(msg +  " " + value);
	}

	public static String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		int[] freq = new int[26];
		boolean[] visited = new boolean[26];

		for(int i=0;i<s.length();i++){
			++freq[s.charAt(i) - 'a'];
		}

		for(int i=0;i<s.length();i++){
			Character ch = s.charAt(i);

			if(visited[ch - 'a']){
				continue;
			}

			visited[ch - 'a'] = true;
			--freq[ch - 'a'];

			while(!stack.isEmpty() && ch < stack.peek() && freq[stack.peek() - 'a'] != 0){
				visited[stack.pop() - 'a'] = false;
			}
			stack.push(ch);
		}

		StringBuilder result = new StringBuilder();
		// p("stack size", stack.size());
		while(!stack.isEmpty()){
			result.append(stack.pop());
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		removeDuplicateLetters("cbacdcbc");
	}
}
