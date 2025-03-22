package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 03-04-2022, Sunday, 18:21
 */
public class SpreadRumorsV1 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        List<Integer>[] adj = new ArrayList[n];

        long[] coins = new long[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            coins[i] = s.nextLong();
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = s.nextInt() - 1, y = s.nextInt() - 1;
            adj[x].add(y);
            adj[y].add(x);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                List<Integer> temp = new ArrayList<>();
                dfs(i, visited, adj, temp);
                long min = Long.MAX_VALUE;
                for (Integer j : temp) {
                    min = Math.min(min, coins[j]);
                }
                ans += min;
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int i, boolean[] visited, List<Integer>[] adj, List<Integer> temp) {
        visited[i] = true;
        temp.add(i);
        for (Integer x : adj[i]) {
            if (!visited[x]) {
                dfs(x, visited, adj, temp);
            }
        }

    }

    public static void main(String[] args) {
        solve();
    }
}
