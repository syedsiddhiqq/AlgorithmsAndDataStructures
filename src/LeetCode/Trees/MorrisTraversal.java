package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

    public static List<Integer> getInOrderUsingMorisTraversal(TreeNode root){
        List<Integer> inOrderList = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                // We have reached the leftmost part of the tree.
                inOrderList.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    // Reaching to the right most part of the tree.
                    // To build the thread to the curr node.
                    prev = prev.right;
                }

                if(prev.right == null){
                    // We have reached the right most part of the tree
                    // And thread is not yet connected.
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    // We have reached the right most part of the tree
                    // But thread is already built.
                    // Adding to the in order list and removing the thread.
                    prev.right = null;
                    inOrderList.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inOrderList;
    }

    public static List<Integer> getPreOrderUsingMorisTraversal(TreeNode root){
        List<Integer> preOrderList = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                // We have reached the leftmost part of the tree.
                preOrderList.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    // Reaching to the right most part of the tree.
                    // To build the thread to the curr node.
                    prev = prev.right;
                }

                if(prev.right == null){
                    // We have reached the right most part of the tree
                    // And thread is not yet connected.
                    prev.right = curr;
                    preOrderList.add(curr.val);;
                    curr = curr.left;
                }else{
                    // We have reached the right most part of the tree
                    // But thread is already built.
                    // Adding to the in order list and removing the thread.
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preOrderList;
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(1,2,3,4,5,null,8,null,null,6,7,9);
        System.out.println(getInOrderUsingMorisTraversal(root));
    }
}
