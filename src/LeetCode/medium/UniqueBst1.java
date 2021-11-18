package LeetCode.medium;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 17/08/2021, Tuesday, 00:05
 */
public class UniqueBst1 {
	static class UniqueBstSolution1 {
		public int numTrees(int n) {
			int[] dp = new int[n+1];
			Arrays.fill(dp,0);
			dp[1] = 1;
			dp[2] = 2;
			int answer = 0;
			for(int i=1;i<=n;i++){
				int rightDiff = n-i;
				int leftDiff = i - 1;
				if(rightDiff == 1 && leftDiff == 1){
					answer+=1;
				}
				if(rightDiff >= 2){
					answer+= dp[rightDiff];
				}
				if(leftDiff >= 2){
					answer+= dp[leftDiff];
				}

				if(dp[i] == 0){
					dp[i] = answer;
				}
			}
			return dp[n];
		}
	}

	public static void main(String[] args) {
		System.out.println(new UniqueBstSolution1().numTrees(4));
	}
}
