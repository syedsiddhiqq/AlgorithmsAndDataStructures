package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 00:39
 */
public class GroupAnagrams {
	static class Solution {

//		public boolean isAnagram(String s, String t) {
//			boolean isAnagram = true;
//			int[] freqOfS = new int[27];
//			for (int i = 0; i < s.length(); i++) {
//				++freqOfS[s.charAt(i) - 'a'];
//			}
//
//			for (int i = 0; i < t.length(); i++) {
//				int ch = t.charAt(i) - 'a';
//				if (freqOfS[ch] > 0) {
//					--freqOfS[ch];
//				} else {
//					isAnagram = false;
//					break;
//				}
//			}
//
//			for (int i = 0; i < 27 && isAnagram; i++) {
//				if (freqOfS[i] >= 1) {
//					isAnagram = false;
//				}
//			}
//			return isAnagram;
//		}

		public boolean isAnagram(String s, String t) {
			char[] str1 = s.toCharArray();
			Arrays.sort(str1);

			char[] str2 = t.toCharArray();
			Arrays.sort(str2);

			StringBuilder s1 = new StringBuilder();
			s1.append(str1);
			StringBuilder s2 = new StringBuilder();
			s2.append(str2);
			return s1.toString().equals(s2.toString());
		}

		public List<List<String>> groupAnagrams(String[] strs) {
			int[] added = new int[strs.length];
			List<List<String>> result = new ArrayList<>();
			for (int i = 0; i < strs.length; i++) {
				if (added[i] == 0) {
					List<String> temp = new ArrayList<>();
					temp.add(strs[i]);
					added[i] = 1;
					for (int j = i + 1; j < strs.length; j++) {
						if (added[j] == 0 && isAnagram(strs[i], strs[j])) {
							temp.add(strs[j]);
							added[j] = 1;
						}
					}
					result.add(temp);
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
}
