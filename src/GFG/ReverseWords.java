package GFG;

import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 06/03/2021, Saturday, 19:13
 */
public class ReverseWords {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			String s = sc.next();
			ReverseWordsSolution obj = new ReverseWordsSolution();
			System.out.println(obj.reverseWords(s));
			t--;
		}
	}
}

class ReverseWordsSolution{
	String reverseWords(String s){
		String[] words = s.split("\\.");
		StringBuilder result = new StringBuilder(words[words.length - 1]);
		for(int i=words.length-2;i>=0;i--){
			result.append(".").append(words[i]);
		}
		return result.toString();
	}
}
