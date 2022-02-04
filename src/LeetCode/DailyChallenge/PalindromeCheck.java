package LeetCode.DailyChallenge;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Syed Ali.
 * @createdAt 05/01/2022, Wednesday, 13:33
 */
public class PalindromeCheck {
	private static boolean isPalindrome(String s){
		StringBuilder reverseStr = new StringBuilder(s);
		reverseStr.reverse();
		return s.equals(reverseStr.toString());
	}

	public static void main(String[] args) {
		//System.out.println(isPalindrome("madame"));

		TreeMap<Integer, Integer> t  = new TreeMap<>();

		t.put(5,3);

		System.out.println(t.lowerKey(5));
	}

}
