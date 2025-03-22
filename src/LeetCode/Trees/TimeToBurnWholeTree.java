package LeetCode.Trees;

import java.util.*;

public class TimeToBurnWholeTree {
    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        Map<Integer, List<BinaryTreeNode<Integer>>> adjMap = new HashMap<>();
        buildAdjList(root, adjMap);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int minutes = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer node = q.poll();
                if (adjMap.containsKey(node)) {
                    List<BinaryTreeNode<Integer>> adjList = adjMap.get(node);
                    adjMap.remove(node);
                    for (BinaryTreeNode<Integer> adjNode : adjList) {
                        if (adjMap.containsKey(adjNode.data)) {
                            q.add(adjNode.data);
                        }
                    }
                }
            }
            minutes++;
        }
        return minutes;
    }

    private static void buildAdjList(BinaryTreeNode<Integer> root, Map<Integer, List<BinaryTreeNode<Integer>>> adjMap) {
        if (root != null) {
            if (root.data != null && root.data != -1) {
                adjMap.putIfAbsent(root.data, new ArrayList<>());
                if (root.left != null) {
                    adjMap.get(root.data).add(root.left);
                    if (root.left.data != null && root.left.data != -1) {
                        adjMap.putIfAbsent(root.left.data, new ArrayList<>());
                        adjMap.get(root.left.data).add(root);
                    }
                }

                if (root.right != null) {
                    adjMap.get(root.data).add(root.right);
                    if (root.right.data != null && root.right.data != -1) {
                        adjMap.putIfAbsent(root.right.data, new ArrayList<>());
                        adjMap.get(root.right.data).add(root);
                    }
                }
            }
            buildAdjList(root.left, adjMap);
            buildAdjList(root.right, adjMap);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.newTree(1, 2, 3, null, null, 4, 5, null, null, null, null);
        int timeToBurn = timeToBurnTree(root, 3);
        System.out.println(timeToBurn);
    }
}
