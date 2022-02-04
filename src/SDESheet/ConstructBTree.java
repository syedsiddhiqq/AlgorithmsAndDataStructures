package SDESheet;

/**
 * @author Syed Ali.
 * @createdAt 26/12/2021, Sunday, 16:28
 */
public class ConstructBTree {

	public class TreeNode {
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

	ConstructBTree(){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(6);
		root.right =new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
	}


	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return construct(preorder,inorder,0,preorder.length,0,preorder.length);
	}

	private TreeNode construct(int[] preorder, int[] inorder, int start, int end,int preStart, int n){
		if(start >= end || start < 0 || start >= n || preStart >= n) return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		for(int i=start;i<end;i++){
			if(inorder[i] == preorder[preStart]){
				root.left = construct(preorder,inorder,start,i,preStart + 1,n);
				root.right = construct(preorder,inorder,i+1,end,preStart + (i - start) + 1 ,n);
				return root;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		ConstructBTree b = new ConstructBTree();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		b.buildTree(preorder,inorder);
	}
}
