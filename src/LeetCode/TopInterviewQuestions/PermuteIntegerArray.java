package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 03:29
 */
public class PermuteIntegerArray {
	static class Solution {

		List<List<Integer>> result = new ArrayList<>();

		void permute(int[] nums, int l, int r) {
			if (l == r && nums.length > 0){
				result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			}
			else {
				for (int i = l; i <= r; i++) {
					nums = swap(nums, l, i);
					permute(nums, l + 1, r);
					nums = swap(nums, l, i);
				}
			}
		}


		int[] swap(int[] nums, int a, int b) {
			int temp = nums[a];
			nums[a] = nums[b];
			nums[b] = temp;
			return nums;
		}


		public List<List<Integer>> permute(int[] nums) {
			permute(nums, 0, nums.length - 1);
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().permute(new int[]{1, 2, 3}));
	}
}
