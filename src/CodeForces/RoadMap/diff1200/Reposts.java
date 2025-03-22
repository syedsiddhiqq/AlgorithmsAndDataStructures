package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-03-2022, Wednesday, 09:04
 */
public class Reposts {
    private static Scanner s = new Scanner(System.in);

    private static class Node {
        private String name;
        private List<Node> childs = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }
    }

    private static void solve() {
        int n = s.nextInt();
        Map<String, Node> nodeMap = new HashMap<>();
        s.nextLine();
        for (int i = 0; i < n; i++) {
            String[] words = s.nextLine().split("\\s+");

            String poster = words[0].toLowerCase();
            String postedBy = words[2].toLowerCase();

            Node currNode = null;
            if (nodeMap.containsKey(poster)) {
                currNode = nodeMap.get(poster);
            } else {
                currNode = new Node(poster);
            }

            nodeMap.put(poster, currNode);
            if (nodeMap.containsKey(postedBy)) {
                Node parentNode = nodeMap.get(postedBy);
                parentNode.childs.add(currNode);
            } else {
                Node parentNode = new Node(postedBy);
                parentNode.childs.add(currNode);
                nodeMap.put(postedBy, parentNode);
            }
        }

        System.out.println(dfs(nodeMap.get("polycarp"), 1));
    }

    private static int dfs(Node parentNode, int height) {
        if (parentNode != null && !parentNode.childs.isEmpty()) {
            int maxHeight = height;
            for (Node child : parentNode.childs) {
                maxHeight = Math.max(maxHeight, dfs(child, height + 1));
            }
            return maxHeight;
        }
        return height;
    }

    public static void main(String[] args) {
        solve();
    }
}
