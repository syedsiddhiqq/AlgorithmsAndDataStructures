package LeetCode.Trees;

/**
 * @author Syed Ali.
 * @createdAt 02/05/2021, Sunday, 03:01
 */
public class IncreasingOrderBst {
	static class Solution {

		TreeNode curr = null;
		public TreeNode increasingBST(TreeNode root) {
			if(root == null){
				return root;
			}
			TreeNode res = new TreeNode(0);
			curr = res;
			inOrder(root);
			return res.right;
		}

		public void inOrder(TreeNode root){
			if(root == null){
				return;
			}
			inOrder(root.left);
			curr.right = root;
			root.left = null;
			curr = root;
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.newTree(5,3,6,2,4,null,8,1,null,null,null,7,9);
		new Solution().increasingBST(root);
	}
}
