package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 01:55
 */
public class FindMinInRotatedSortedArr {
	static class Solution {
		public int findMin(int[] nums) {
			int start = 0, high = nums.length - 1;
			while (start < high) {
				if (nums[start] < nums[high]) {
					return nums[start];
				}

				int mid = (start + high) / 2;
				if (nums[mid] >= nums[start]) {
					start = mid + 1;
				} else {
					high = mid;
				}
			}
			return nums[start];
		}
	}
}
