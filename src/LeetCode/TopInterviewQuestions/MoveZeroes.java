package LeetCode.TopInterviewQuestions;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 02:51
 */
public class MoveZeroes {
	static class Solution {

		public void moveZeroes(int[] nums) {
			int aPointer = 0;
			while (aPointer < nums.length) {
				if (nums[aPointer] == 0) {
					for (int j = aPointer + 1; j < nums.length; j++) {
						if (nums[j] != 0) {
							int temp = nums[j];
							nums[j] = nums[aPointer];
							nums[aPointer] = temp;
							break;
						}
					}
				}
				++aPointer;
			}
		}
	}
}
