package LeetCode.Greedy;

/**
 * @author Syed Ali.
 * @createdAt 24/11/2021, Wednesday, 22:58
 */
public class SortColors {
	private static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void sortColors(int[] nums) {
		int start = 0,n = nums.length;
		int zeroIndex = 0, twoIndex = n-1;
		while(start < n ){
			if(nums[start] == 2 && start < twoIndex){
				swap(nums,start,twoIndex);
				twoIndex--;
			}else if(nums[start] == 0){
				swap(nums,zeroIndex, start);
				zeroIndex++;
				start++;
			}else{
				start++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {2,0,1};
		sortColors(arr);
	}
}
