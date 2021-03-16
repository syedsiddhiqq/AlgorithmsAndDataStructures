package LeetCode.Easy;

/**
 * @author Syed Ali.
 * @createdAt 14/12/2020, Monday, 15:59
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class RunningSum {
	static class Solution {
		public Solution() {
		}

		public int[] runningSum(int[] nums) {
			for (int i = 1; i < nums.length; i++) {
				nums[i] = nums[i-1] + nums[i];
			}
			return nums;
		}
	}

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		new Solution().runningSum(nums);
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
