package LeetCode.medium;

/**
 * @author Syed Ali.
 * @createdAt 15/08/2021, Sunday, 15:29
 */
public class LongestPalindromicSubString {
	static class Solution {
		public String longestPalindrome(String s) {

//			System.out.println(s.substring(0,2));
			int n = s.length();
			boolean[][] dp = new boolean[n][n];
			char[] str = s.toCharArray();
			int maxLength = 0, start = 0;

			for (int i = 0; i < n; i++) {
				dp[i][i] = true;
				maxLength = 1;
				start = i;
			}

			for (int i = 0; i < n - 1; 	i++) {
				if (str[i] == str[i + 1]) {
					dp[i][i + 1] = true;
					maxLength = 2;
					start = i;
				}
			}

			for (int k = 3; k < n; k++) {
				for (int i = 0; i < n - k + 1; i++) {
					int j = i+k-1;
					if(str[i] == str[j] && dp[i+1][j-1]){
						dp[i][j] = true;
						if(k > maxLength){
							maxLength = k;
							start = i;
						}
					}
				}
			}
			return s.substring(start, start + maxLength);
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome("aaaabbaa"));
	}

}
