package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 29-04-2022, Friday, 10:53
 */
public class NotAssigning {
    static List<Integer> adj[];
    static Map<String, Integer> prime;
    static boolean vis[];

    static void dfs(int u, int val) {
        vis[u] = true;
        for (int v : adj[u]) {
            if (vis[v]) continue;
            prime.put(u + ":" + v, val);
            prime.put(v + ":" + u, val);
            dfs(v, val == 2 ? 3 : 2);
        }
    }

    static String solve(int n, List<int[]> edges) {
        prime = new HashMap<>();
        adj = new ArrayList[n];
        vis = new boolean[n];
        Arrays.setAll(adj, idx -> new ArrayList<>());
        boolean isPossible = true;
        List<Integer> start = new ArrayList<>();
        for (int edge[] : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 0; i < n; i++) {
            int size = adj[i].size();
            if (size == 1) start.add(i);
            if (size > 2) isPossible = false;
        }
        if (!isPossible) return "-1";
        for (int u : start) {
            if (vis[u]) continue;
            dfs(u, 3);
        }
        StringBuilder sb = new StringBuilder();
        for (int edge[] : edges) {
            int u = edge[0], v = edge[1];
            sb.append(prime.getOrDefault(u + ":" + v, 2) + " ");
        }
        return sb.toString();
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (tests-- > 0) {
            int n = sc.nextInt();
            List<int[]> edges = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                edges.add(new int[]{u, v});
            }
            String res = solve(n, edges);
            sb.append(res + "\n");
        }
        System.out.println(sb.toString());
    }
}
