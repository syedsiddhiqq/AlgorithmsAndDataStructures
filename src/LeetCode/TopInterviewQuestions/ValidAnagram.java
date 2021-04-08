package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 01:15
 */
public class ValidAnagram {
	static class Solution {
		public boolean isAnagram(String s, String t) {
			boolean isAnagram = true;
			int[] freqOfS = new int[27];
			for (int i = 0; i < s.length(); i++) {
				++freqOfS[s.charAt(i) - 'a'];
			}

			for (int i = 0; i < t.length(); i++) {
				int ch = t.charAt(i) - 'a';
				if (freqOfS[ch] > 0) {
					--freqOfS[ch];
				} else {
					isAnagram = false;
					break;
				}
			}

			for (int i = 0; i < 27 && isAnagram; i++) {
				if (freqOfS[i] >= 1) {
					isAnagram = false;
				}
			}
			return isAnagram;
		}
	}
}
