package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 04:07
 */
public class GenerateParenthesis {
	static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	static void backtrack(List<String> list, String str, int open, int close, int max){

		if(str.length() == max*2){
			list.add(str);
			return;
		}

		if(open < max)
			backtrack(list, str+"(", open+1, close, max);
		if(close < open)
			backtrack(list, str+")", open, close+1, max);
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
}
