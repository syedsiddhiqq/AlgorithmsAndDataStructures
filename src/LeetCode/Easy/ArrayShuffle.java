package LeetCode.Easy;

/**
 * @author Syed Ali.
 * @createdAt 14/12/2020, Monday, 22:41
 * https://leetcode.com/problems/shuffle-the-array
 */
public class ArrayShuffle {
	public static class Solution {
		public int[] shuffle(int[] nums, int n) {
			int[] output = new int[n*2];
			int index = 0;
			for (int i = 0; i < n; i++) {
				output[index++] = nums[i];
				output[index++] = nums[i+n];
			}
			return output;
		}
	}

	public static void main(String[] args) {
		int[] nums = {2,5,1,3,4,7};
		Solution solution = new Solution();
		int[] output = solution.shuffle(nums,nums.length/2);
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
}
