package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 23:15
 */
public class ProductOfArray {
	class Solution {
		public int[] productExceptSelf(int[] nums) {
			int totalProduct = 1;
			int countOfZero = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					totalProduct *= nums[i];
				} else {
					++countOfZero;
				}
			}

			for (int i = 0; i < nums.length; i++) {
				if (countOfZero == 1) {
					if (nums[i] != 0) {
						nums[i] = 0;
					} else {
						if (countOfZero == nums.length) {
							nums[i] = 0;
						} else {
							nums[i] = totalProduct;
						}
					}
				} else if (countOfZero > 1) {
					nums[i] = 0;
				} else {
					nums[i] = totalProduct / nums[i];
				}
			}
			return nums;
		}
	}

	public static void main(String[] args) {

	}
}
