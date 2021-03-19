package Algorithms;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 19/03/2021, Friday, 22:58
 */
public class Subsequences {

	static boolean checkPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) return false;
		}
		return true;
	}

	private static int findsubsequences(String s,String ans,int max) {
		if (s.length() == 0) {
			if (checkPalindrome(ans)) {
				max = Math.max(max,ans.length());
			}
			return max;
		}
		return Math.max(findsubsequences(s.substring(1), ans + s.charAt(0),max),findsubsequences(s.substring(1), ans,max));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int max = 0;
		while(t-->0){
			int n = scanner.nextInt();
			StringBuilder s = new StringBuilder();
			for(int i=0;i<n;i++){
				int temp = scanner.nextInt();
				char ch = (char)( 'a' + temp - 1);
				s.append(ch);
			}
			System.out.println(findsubsequences(s.toString(), "",max));
		}
	}


}
