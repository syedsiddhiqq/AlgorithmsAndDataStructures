package LeetCode.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                sb.append(node.val);
                q.add(node.left);
                q.add(node.right);
            } else {
                sb.append("#");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] nodeStrArr = data.split(",");
        if (nodeStrArr.length == 0) return null;
        int length = nodeStrArr.length;
        Queue<TreeNode> q = new LinkedList<>();
        int start = 0;
        String strVal = nodeStrArr[start];
        if("#".equals(strVal)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strVal));
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                int leftIndex = (2 * start) + 1;
                int rightIndex = (2 * start) + 2;
                if (leftIndex < length) {
                    strVal = nodeStrArr[leftIndex];
                    if (!strVal.equals("#")) {
                        node.left = new TreeNode(Integer.parseInt(strVal));
                        q.add(node.left);
                    }
                }

                if (rightIndex < length) {
                    strVal = nodeStrArr[rightIndex];
                    if (!strVal.equals("#")) {
                        node.right = new TreeNode(Integer.parseInt(strVal));
                        q.add(node.right);
                    }
                }
                start++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree();
        String serializedTree = serialize(root);
        System.out.println(serializedTree);

        root = deserialize(serializedTree);
        System.out.println(root);
    }
}
