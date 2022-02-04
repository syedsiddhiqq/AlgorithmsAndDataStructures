package LeetCode.Amazon;

/**
 * @author Syed Ali.
 * @createdAt 02/12/2021, Thursday, 23:02
 */
public class TrappingRainWater {
	public static int trap(int[] height) {
		int n = height.length;
		int[] pre = new int[n];
		int[] suff = new int[n];


		pre[0] = height[0];
		suff[n - 1] = height[n-1];
		for(int i=1,j=n-2;i<n && j>=0;i++,j--){
			pre[i] = Math.max(height[i],pre[i-1]);
			suff[j] = Math.max(height[j],suff[j+1]);
		}

		int answer = 0;
		for(int i=0;i<n;i++){
			answer += Math.min(pre[i],suff[i]) - height[i];
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		trap(arr);
	}
}
