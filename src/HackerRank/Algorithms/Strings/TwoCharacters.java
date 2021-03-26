package HackerRank.Algorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 03:07
 */
public class TwoCharacters {

	static List<String> subSequence = new ArrayList<>();

	static int maxLength = Integer.MIN_VALUE;

	static boolean checkForTwoAlternatingChars(String s){
		char[] str = s.toCharArray();
		for(int i=1;i<s.length();i++){
			if(str[i] == str[i-1]){
				return false;
			}
		}
		return true;
	}

	static boolean checkForTwoChars(String s){
		char[] str = s.toCharArray();
		int[] freq = new int[27];
		int charCount = 0;
		for(int i=0;i<str.length;i++){
			int temp = str[i]-'a';
			if(freq[temp] == 0){
				++charCount;
			}
			freq[temp]++;
		}

		if(charCount == 2) return true;
		return false;
	}


	static void generateSubsequences(String s,String ans){
		if(s.length() == 0){
			if(checkForTwoChars(ans) && checkForTwoAlternatingChars(ans)) {
				subSequence.add(ans);
				if(maxLength < ans.length()){
					maxLength = ans.length();
				}
			}
			return;
		}

		// traverse left
		generateSubsequences(s.substring(1),ans + s.charAt(0));
		generateSubsequences(s.substring(1),ans);
	}

	static int alternate(String s) {
		generateSubsequences(s,"");
		return maxLength;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		String s = bufferedReader.readLine();
		System.out.println(alternate(s));
	}
}
