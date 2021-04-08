package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 00:42
 */
public class SortedArrayToBst {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
//		solve();
	}

	static class Solution {
		public TreeNode createBST(int[] nums, int start, int end) {
			if (start > end) {
				return null;
			}
			int mid = (start + end) / 2;
			TreeNode root = new TreeNode(nums[mid]);
			root.left = createBST(nums, start, mid - 1);
			root.right = createBST(nums, mid + 1, end);
			return root;
		}

		public TreeNode sortedArrayToBST(int[] nums) {
			return createBST(nums, 0, nums.length - 1);
		}
	}
}
