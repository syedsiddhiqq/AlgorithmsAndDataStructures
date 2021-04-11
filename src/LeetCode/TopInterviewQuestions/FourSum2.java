package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 11/04/2021, Sunday, 02:45
 */
public class FourSum2 {
	static class Solution {

		int count = 0;

		void dfs(int[][] grid, int row, int col, int i, int j, int sum) {
			if (i < 0 || i >= row || j < 0 || j >= col) {
				return;
			}

			sum = sum + grid[i][j];

			if (sum == 0 && i == 3) {
				++count;
			}

			for (int k = 0; k < col; k++) {
				dfs(grid, row, col, i + 1, k, sum);
			}
		}

		public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
			int col = nums1.length;
			int[][] grid = new int[4][col];

			for (int i = 0; i < col; i++) {
				grid[0][i] = nums1[i];
				grid[1][i] = nums2[i];
				grid[2][i] = nums3[i];
				grid[3][i] = nums4[i];
			}
			for (int i = 0; i < col; i++) {
				dfs(grid, 4, col, 0, i, 0);
			}
			return count;
		}
	}

	public static void main(String[] args) {
//		int[] nums1 = {1,2};
//		int[] nums2 = {-2,-1};
//		int[] nums3 = {1,2};
//		int[] nums4	 = {0,2};

		int[] nums1 = {1};
		int[] nums2 = {-1};
		int[] nums3 = {0};
		int[] nums4	 = {1};
		System.out.println(new Solution().fourSumCount(nums1,nums2,nums3,nums4));
	}
}
