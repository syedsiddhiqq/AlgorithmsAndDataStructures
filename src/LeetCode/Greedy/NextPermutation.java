package LeetCode.Greedy;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 24/11/2021, Wednesday, 19:51
 */
public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		int n = nums.length;

		int i = n-1;
		while(i > 0 && nums[i] <= nums[i-1])
			i--;

		if(i == 0){
			Arrays.sort(nums);
		}else{
			int j = n - 1;
			while (nums[j] <= nums[i - 1])
				j--;

			int temp = nums[j];
			nums[j] = nums[i-1];
			nums[i-1] = temp;

			j = n-1;
			while(j > i){
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}

		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		nextPermutation(arr);
	}
}
