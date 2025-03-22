package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private static void dfs(TreeNode root, String path, List<String> result){
        if(root == null) return;
        if(root.left == null && root.right == null){
            result.add(path + root.val);
            return;
        }else{
            dfs(root.left, path + root.val + "->", result);
            dfs(root.right, path + root.val + "->", result);
        }
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.newTree(1,2,3,null,5);
//        System.out.println(binaryTreePaths(root));

        StringBuilder sb = new StringBuilder("testetere");
        sb.setLength(4);
        System.out.println(sb.toString());
    }
}
