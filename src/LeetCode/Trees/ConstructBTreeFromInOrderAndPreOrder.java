package LeetCode.Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTreeFromInOrderAndPreOrder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i], i);
        }
        return buildTreeUtil(preorder,0, 0, preorder.length - 1, inOrderMap);
    }

    public static TreeNode buildTreeUtil(int[] preOrder, int preStart, int inStart, int inEnd, Map<Integer, Integer> inOrderMap){
        if (preStart >= preOrder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        // Finding the root element in the in order array.
        // InOrder => Left , Root , Right
        // So if we find the root then we can find the left and right subarray;
        int rootIndex = inOrderMap.get(preOrder[preStart]);
        TreeNode left = buildTreeUtil(preOrder,preStart + 1, inStart, rootIndex - 1, inOrderMap);
        TreeNode right = buildTreeUtil(preOrder,preStart + (rootIndex - inStart) + 1, rootIndex + 1, inEnd, inOrderMap);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        System.out.println(buildTree(preOrder, inOrder));
    }
}
