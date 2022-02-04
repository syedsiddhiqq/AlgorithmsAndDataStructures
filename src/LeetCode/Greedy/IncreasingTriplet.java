package LeetCode.Greedy;

/**
 * @author Syed Ali.
 * @createdAt 20/11/2021, Saturday, 16:22
 * 107190
 */
public class IncreasingTriplet {
	public static boolean increasingTriplet(int[] nums) {
		int min = Integer.MAX_VALUE, second_min = Integer.MAX_VALUE;
		for(int num : nums){
			if(num <= min) min=num;
			else if(num<second_min) second_min = num;
			else if(num > second_min) return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = {2,1,5,0,4,6};
		System.out.println(increasingTriplet(nums));
	}
}
