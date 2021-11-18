package LeetCode.medium;

import java.util.Arrays;

/**
 * @author Syed Ali.
 * @createdAt 12/08/2021, Thursday, 16:20
 */
public class JumpGame {
	static class Solution {
		public int jump(int[] nums) {
			int[] pre = new int[nums.length];
			Arrays.fill(pre,Integer.MAX_VALUE);

			pre[0] = 0;
			for(int i=0;i<nums.length;i++){
				for(int j=i;j<=i+nums[i] && j<nums.length;j++){
					pre[j] = Math.min(pre[j],pre[i]+1);
				}
			}
			return pre[nums.length - 1];
		}
	}

	public static void main(String[] args) {
		int[] arr = {2,3,1,1,4};
		System.out.println(new Solution().jump(arr));
	}
}
