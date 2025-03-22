package LeetCode.Trees;

public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        return dfs(root.left, Long.MIN_VALUE, root.val) && dfs(root.right, root.val, Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode root,long min, long max) {
        if(root == null) return true;
        if(root.val > min && root.val < max){
            return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(3,1,5,0,2,4,6);
        System.out.println(isValidBST(root));
    }
}
