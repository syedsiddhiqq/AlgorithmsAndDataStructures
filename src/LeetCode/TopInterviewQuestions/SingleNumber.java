package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 15/12/2020, Tuesday, 06:09
 */
public class SingleNumber {
	public static class Solution{
//		public int singleNumber(int[] nums){
//			Arrays.sort(nums);
//			for (int i = 0; i < nums.length-1;i+=2) {
//				if(nums[i] != nums[i+1]) return nums[i];
//			}
//			return nums[nums.length-1];
//		}

		public int singleNumber(int[] nums){
			int res = 0;
			for(Integer num : nums) {
				res^=num;
			};
			return res;
		}
	}

	public static void main(String[] args) {
		Solution solution =  new Solution();
		System.out.println(solution.singleNumber(new int[]{9, 5, 2, 2, 5}));
	}
}
