package LeetCode.TopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 00:57
 */
public class MajorityElement {
	static class Solution {
		public int majorityElement(int[] nums) {
			int maxFrequency = Integer.MIN_VALUE;
			int majorityElement = 0;
			Map<Integer, Integer> dataMap = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (dataMap.containsKey(nums[i])) {
					int value = dataMap.get(nums[i]) + 1;
					dataMap.put(nums[i], value);
					if (maxFrequency < value) {
						maxFrequency = value;
						majorityElement = nums[i];
					}
				} else {
					if (maxFrequency < 1) {
						maxFrequency = 1;
						majorityElement = nums[i];
					}
					dataMap.put(nums[i], 1);
				}
			}
			return majorityElement;
		}
	}
}
