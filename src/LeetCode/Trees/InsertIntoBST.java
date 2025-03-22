package LeetCode.Trees;

public class InsertIntoBST {

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode parent = null;
        while(root != null){
            parent = root;
            if(val <= root.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }

        if(val <= parent.val){
            parent.left = new TreeNode(val);
        }else{
            parent.right = new TreeNode(val);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(4,2,7,1,3);
        System.out.println(insertIntoBST(root, 5));
    }
}
