package LeetCode.Amazon.Medium;

/**
 * @author Syed Ali.
 * @createdAt 23/10/2021, Saturday, 13:33
 */
public class ThreeSumClosest {
	public static int answer = Integer.MAX_VALUE;

	public static int threeSumClosest(int[] nums, int target) {
		int length = nums.length;
		boolean[] visited = new boolean[length];
		for(int i=0;i<length;i++){
			visited[i] = true;
			solve(nums,visited,nums[i],1,target, length);
			visited[i] = false;
		}
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	public static void solve(int[] nums,boolean[] visited,int sum, int times, int target, int length){
		if(times == 3 ){
			if(Math.abs(sum - target) < answer){
				answer = sum;
			}
		}else if(times < 3){
			for(int i=0;i<length;i++){
				if(!visited[i]){
					visited[i] = true;
					solve(nums,visited,sum+nums[i],times + 1,target,length);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,1,-1};
		System.out.println(threeSumClosest(arr,2));
	}
}
