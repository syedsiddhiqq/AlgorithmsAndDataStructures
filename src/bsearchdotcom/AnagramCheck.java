package bsearchdotcom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 20/03/2021, Saturday, 22:40
 */
public class AnagramCheck {
}

class Solution {
	public List<String> fetchSubstrings(String str, int n) {
		List<String> subStrings = new ArrayList<>();
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++) subStrings.add(str.substring(i, j));

		return subStrings;
	}

	static boolean areAnagram(char[] str1, char[] str2) {
		// Get lenghts of both strings
		int n1 = str1.length;
		int n2 = str2.length;

		// If length of both strings is not same,
		// then they cannot be anagram
		if (n1 != n2)
			return false;

		// Sort both strings
		Arrays.sort(str1);
		Arrays.sort(str2);

		// Compare sorted strings
		for (int i = 0; i < n1; i++)
			if (str1[i] != str2[i])
				return false;

		return true;
	}

	public String[] solve(String s) {
		List<String> subStrings = fetchSubstrings(s, s.length());
		List<String> result = new ArrayList<>();
		Map<Integer,Boolean> anagramMap = new HashMap<>();
		if (!subStrings.isEmpty()) {
			for (int i = 0; i < subStrings.size(); i++) {
				for (int j = i + 1; j < subStrings.size(); j++) {
					if ( areAnagram(subStrings.get(i).toCharArray(),
							subStrings.get(j).toCharArray())) {
						anagramMap.put(i,true);
						anagramMap.put(j,true);
					}
				}
			}
		}
		anagramMap.keySet().forEach(key->{
			if (anagramMap.get(key)){
				result.add(subStrings.get(key));
			}
		});
		String[] results = new String[result.size()];
		Collections.sort(result);
		for (int i = 0; i < result.size(); i++) results[i] = result.get(i);
		return results;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.solve("aba")));
	}
}
