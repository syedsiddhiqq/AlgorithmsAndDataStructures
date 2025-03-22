package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 29-03-2022, Tuesday, 21:16
 */
public class ChristmasSpruce {
    private static Scanner s = new Scanner(System.in);

    private static class Node {
        Integer key;
        List<Node> nodes = new ArrayList<>();

        public Node(Integer key) {
            this.key = key;
        }
    }

    private static void solve() {
        int n = s.nextInt();
        Map<Integer, Node> nodes = new HashMap<>();
        nodes.put(1, new Node(1));

        int start = 2;
        for (int i = 0; i < n - 1; i++) {
            int temp = s.nextInt();
            Node node = new Node(start);
            if (nodes.containsKey(temp)) {
                Node parentNode = nodes.get(temp);
                parentNode.nodes.add(node);
            } else {
                Node parentNode = new Node(temp);
                parentNode.nodes.add(node);
                nodes.put(temp, parentNode);
            }
            nodes.put(start++, node);
        }

        for (Integer key : nodes.keySet()) {
            Node parentNode = nodes.get(key);
            if (parentNode.nodes.size() > 0) {
                int count = 0;
                for (Node child : parentNode.nodes) {
                    if (child.nodes.size() == 0) {
                        count++;
                    }
                    if (count == 3) break;
                }
                if (count < 3) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        solve();
    }
}
