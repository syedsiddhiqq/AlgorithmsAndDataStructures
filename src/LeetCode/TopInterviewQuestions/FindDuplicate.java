package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 03:30
 */
public class FindDuplicate {
	static int findDuplicate3(int[] nums) {
		if (nums.length > 1) {
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;
			while (fast != slow) {
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findDuplicate3(new int[]{1,3,4,2,2}));
	}
}
