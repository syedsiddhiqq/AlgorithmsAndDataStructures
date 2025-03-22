package LeetCode.Trees;

public class DeleteANodeBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode parent = null;
        while(curr != null){
            if(key == curr.val){
                if(curr.right != null){
                    TreeNode temp = curr.right;
                    if(parent == null){
                        root = curr.right;
                    }else{
                        parent.left = curr.right;
                    }
                    while(temp.left != null){
                        temp = temp.left;
                    }
                    temp.left = curr.left;
                }else{
                    parent.left = curr.left;
                }
                return root;
            }else if(key < root.val){
                parent = curr;
                curr = curr.left;
            }else{
                parent = curr;
                curr = curr.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(5,3,6,2,4,null,7);
        TreeNode newRootAfterDelete = deleteNode(root, 5);
        System.out.println(newRootAfterDelete);
    }
}
