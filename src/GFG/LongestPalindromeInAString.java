package GFG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 07/03/2021, Sunday, 00:28
 */
public class LongestPalindromeInAString {
	static Scanner scanner = new Scanner(System.in);

	public static Boolean checkForPalindrome(String s, int start, int end) {
		for(int i=start,j = end;i<end && j >=start && i < j;i++,j--){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
		return true;
	}

	public static String findMaxPalindrome(String s, int start, int end){
		int maxPalindromeLength = Integer.MIN_VALUE;
		String maxPalindrome = null;
		for(int i=start;i<=end;i++){
			for(int j=end;j>=0 && i <= j;j--){
				if(checkForPalindrome(s,i,j)){
					int length = (j - i) + 1;
					if(length > maxPalindromeLength){
						maxPalindromeLength = length;
						maxPalindrome = s.substring(i,j+1);
					}
				}
			}
		}
		return maxPalindrome;
	}

	public static void solve(String s){
		System.out.println(findMaxPalindrome(s,0,s.length()-1));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = scanner.nextInt();
		while(t-->0){
			String s = br.readLine();
			solve(s);
		}
//		System.out.println(checkForPalindrome("aaaaba",3,5));
	}


}
