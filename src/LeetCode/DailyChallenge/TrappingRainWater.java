package LeetCode.DailyChallenge;

/**
 * @author Syed Ali.
 * @createdAt 07/01/2022, Friday, 14:41
 */
public class TrappingRainWater {
	public static int trap(int[] height) {
		int n = height.length;
		int[] left  = new int[n];
		int[] right = new int[n];

		left[0] = height[0];
		right[n-1] = height[n-1];
		for(int i=1,j=n-2;i<n && j>=0;i++,j--){
			left[i] = Math.max(height[i],left[i-1]);
			right[j] = Math.max(height[j],right[j+1]);
		}


		int ans = 0;
		for(int i=0;i<n;i++){
			ans += (Math.min(left[i],right[i]) - height[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}
