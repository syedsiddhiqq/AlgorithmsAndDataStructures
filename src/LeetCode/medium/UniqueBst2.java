package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 16/08/2021, Monday, 22:02
 */
public class UniqueBst2 {

	 static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }

	static class UniqueBstSolution {
		public List<TreeNode> generateTrees(int n) {
			return generate(1,n);
		}

		public List<TreeNode> generate(int start, int end){
			List<TreeNode> list = new ArrayList<>();
			if(start > end){
				list.add(null);
				return list;
			}

			if(start == end){
				list.add(new TreeNode(start));
				return list;
			}

			List<TreeNode> left,right;
			for(int i=start;i<=end;i++)
			{

				left = generate(start, i-1);
				right = generate(i+1,end);

				for(TreeNode lnode: left)
				{
					for(TreeNode rnode: right)
					{
						TreeNode root = new TreeNode(i);
						root.left = lnode;
						root.right = rnode;
						list.add(root);
					}
				}

			}
			return list;
		}
	}

	public static void main(String[] args) {
		System.out.println(new UniqueBstSolution().generateTrees(3));
	}
}
