package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 11/04/2021, Sunday, 18:19
 */
public class ContainerWithMostWater {
	static class Solution {
		public int maxArea(int[] height) {
			int aPointer = 0;
			int bPointer = height.length - 1;
			int maxArea = 0;
			while (aPointer < bPointer) {
				maxArea = Math.max(maxArea, (bPointer - aPointer) * Math.min(height[aPointer], height[bPointer]));
				if (height[aPointer] < height[bPointer]) {
					aPointer++;
				} else {
					bPointer--;
				}
			}
			return maxArea;
		}
	}
}
