package LeetCode.TopInterviewQuestions;

/**
 * @author Syed Ali.
 * @createdAt 15/12/2020, Tuesday, 06:00
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthOfBinarySearchTree {

	public class TreeNode {
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

	public static class Solution {
		public int maxDepth(TreeNode root) {
			// exit condition
			if(root == null) return 0;
			if(root.left == null && root.right == null) return 1;

			int left = maxDepth(root.left);
			int right  = maxDepth(root.right);
			return Math.max(left,right)+1;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
	}
}
