package CodeForces.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 20/09/2021, Monday, 20:07
 */
public class Generate {
	private static Scanner s = new Scanner(System.in);
	public static List<String> generateParenthesis(int n) {
		List<String> output = new ArrayList<>();
		backTrack(output,"",0,0,n);
		return output;
	}

	private static  void backTrack(List<String> output,String curr,int open,int close,int max){

		if(output.size() >= max) return;

		if(curr.length() == max*2){
			output.add(curr);
			return;
		}

		if(open < max)
			backTrack(output,curr+"(",open+1,close,max);

		if(close < open)
			backTrack(output,curr+")",open,close+1,max);
	}

	public static void main(String[] args) {
		int t = s.nextInt();
		while(t-->0){
			int n = s.nextInt();
			List<String> p = generateParenthesis(n);
			p.forEach(System.out::println);
		}
	}
}
