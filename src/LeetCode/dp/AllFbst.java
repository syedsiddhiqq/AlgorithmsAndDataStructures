package LeetCode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Syed Ali.
 * @createdAt 30/08/2021, Monday, 23:52
 */


class TreeNode {
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


public class AllFbst {

	static HashMap<Integer,List<TreeNode>> cache;
	public static List<TreeNode> allPossibleFBT(int n) {
		cache = new HashMap();
		return solve(n);
	}
	public static List<TreeNode> solve(int n){
		if(n<=0)return null;
		if(n==1){return new ArrayList<TreeNode>(){{add(new TreeNode(0));}};}
		if(cache.containsKey(n))return cache.get(n);
		List<TreeNode> list = new ArrayList<TreeNode>();
		for(int i=1;i<n;i=i+2){
			List<TreeNode> left = solve(i);
			List<TreeNode> right = solve(n-i-1);
			if(left!=null && right!=null){
				for(TreeNode t1:left){
					for(TreeNode t2:right){
						TreeNode root  = new TreeNode(0);
						root.left=t1;
						root.right=t2;
						list.add(root);
					}
				}
			}
		}
		cache.put(n,list);
		return list;
	}

	public static void main(String[] args) {
		allPossibleFBT(7);
	}
}
