package LeetCode.medium;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Syed Ali.
 * @createdAt 02/10/2021, Saturday, 22:06
 */
public class LongestSubStringWithoutRepeatingChar {
	public static boolean checkInvalid(Map<Character, Integer> countMap) {
		return Stream.of(countMap.values()).flatMap(Collection::stream).anyMatch(i -> i > 1);
	}

	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> countMap = new HashMap<>();
		char[] str = s.toCharArray();
		int n = str.length, result = 1;
		int start = 0;
		for (int i = 0; i < n; i++) {
			char ch = str[i];
			if (countMap.containsKey(ch)) {
				countMap.put(ch, countMap.get(ch) + 1);
			} else {
				countMap.put(ch, 1);
			}
			// if valid (i.e count Of any char > 0)...
			while (checkInvalid(countMap)) {
				countMap.put(str[start], countMap.get(str[start++]) - 1);
			}
			// If valid...
			result = Math.max(result, i - start + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bbbbbbeacdaabcdefgh"));
	}
}
