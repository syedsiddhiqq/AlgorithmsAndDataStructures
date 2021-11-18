package LeetCode.medium;

/**
 * @author Syed Ali.
 * @createdAt 12/08/2021, Thursday, 16:16
 */
public class MostWaterInContainer {
	public int maxArea(int[] height) {
		int aPointer = 0;
		int bPointer = height.length - 1;
		int ans = Integer.MIN_VALUE;
		while(aPointer < bPointer){
			ans = Math.max(ans,Math.min(height[aPointer],height[bPointer]) * (bPointer - aPointer));
			if(height[aPointer] < height[bPointer]){
				aPointer++;
			}else{
				bPointer--;
			}
		}
		return ans;
	}
}
