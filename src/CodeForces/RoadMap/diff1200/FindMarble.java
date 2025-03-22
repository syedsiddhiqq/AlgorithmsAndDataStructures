//package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 29-03-2022, Tuesday, 22:05
 */
public class FindMarble {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), initial = s.nextInt(), target = s.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = s.nextInt();
        boolean[] visited = new boolean[n + 1];
        visited[initial] = true;
        int ans = 0;
        while (initial != target) {
            initial = arr[initial];
            if (visited[initial]) {
                System.out.println(-1);
                return;
            }
            ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}
