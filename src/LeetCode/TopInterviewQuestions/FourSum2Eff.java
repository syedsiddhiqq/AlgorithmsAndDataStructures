package LeetCode.TopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 11/04/2021, Sunday, 03:11
 */
public class FourSum2Eff {
	static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		int res = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				res += map.getOrDefault(-1 * (A[i] + B[j]), 0);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {-2, -1};
		int[] nums3 = {1, 2};
		int[] nums4 = {0, 2};
		System.out.println(fourSumCount(nums3, nums4, nums1, nums2));
	}

}
