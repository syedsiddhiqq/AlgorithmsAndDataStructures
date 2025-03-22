package LeetCode.Trees.btrees;


import LeetCode.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        // If current node is p then return p.
        if (root.val == p.val) {
            return p;
        }

        // If current node is q then return q.
        if (root.val == q.val) {
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if both left and right found p and q then current node is the LCA.
        if (left != null && right != null) return root;

        // Return first non-null value either P or Q.
        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestorNaive(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        getPath(root, p, pPath);
        List<TreeNode> qPath = new ArrayList<>();
        getPath(root, q, qPath);

        // System.out.println(pPath.toString());
        // System.out.println(qPath.toString());

        int start = 0, pPathSize = pPath.size(), qPathSize = qPath.size();
        TreeNode lca = root;
        while (start < pPathSize && start < qPathSize) {
            TreeNode pPathNode = pPath.get(start);
            TreeNode qPathNode = qPath.get(start);
            if (pPathNode.val == qPathNode.val) {
                lca = pPathNode;
            }
            start++;
        }
        return lca;
    }

    private boolean getPath(TreeNode root, TreeNode p, List<TreeNode> path) {
        // If leaf node not matching with P
        if (root == null) return false;

        // If node matches with P
        if (root.val == p.val) {
            path.add(root);
            return true;
        }

        // If node not matching with P add the node to the path and traverse further.
        path.add(root);

        // Traverse left and check if P is found.
        boolean left = getPath(root.left, p, path);
        // Traverse right and check if P is found
        boolean right = getPath(root.right, p, path);

        // If P is found then return
        if (left || right) return true;

        // If P not found then remove node from the path.
        path.remove(path.size() - 1);
        return false;
    }
}
