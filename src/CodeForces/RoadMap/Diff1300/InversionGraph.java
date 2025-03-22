package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 09-04-2022, Saturday, 10:13
 */
public class InversionGraph {
    private static Scanner s = new Scanner(System.in);

    private static Set<Integer> getAllAdj(Integer node, Set<Integer>[] nodes, boolean[] visited) {
        Set<Integer> adjs = new HashSet<>();
        for (Integer adjNode : nodes[node]) {
            if (!visited[adjNode]) {
                visited[adjNode] = true;
                adjs.addAll(getAllAdj(adjNode, nodes, visited));
            }
        }
        return adjs;
    }

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n + 1];
        Set<Integer>[] nodes = new HashSet[n + 1];
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodes[i] = new HashSet<>();
            arr[i] = s.nextInt();
            index.put(arr[i], i);
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int start = arr[i] - 1; start >= 1; start--) {
                if (index.get(start) > i) {
                    nodes[arr[i]].add(start);
                    nodes[start].add(arr[i]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                nodes[i].addAll(getAllAdj(arr[i], nodes, visited));
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
