package LeetCode.Trees;

public class CountNodesOfCompleteBTree {
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if (leftHeight == rightHeight) {
            return 2 << leftHeight - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int findLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    private static int findRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(1, 2, 3, 4, 5, 6, 7);
        System.out.println(countNodes(root));
    }
}
