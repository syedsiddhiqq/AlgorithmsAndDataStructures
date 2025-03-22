package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-04-2022, Saturday, 14:28
 */
public class CoinRow {
    private static Scanner s = new Scanner(System.in);

    private static int ans;

    private static void solve() {
        int m = s.nextInt();
        ans = Integer.MAX_VALUE;
        int[][] grid = new int[2][m];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.nextInt();
            }
        }

        coinRowUtil(grid, 0, 0, 0, m - 1, 0);
        System.out.println(ans);
    }

    private static void coinRowUtil(int[][] grid, int operation, int i, int j, int m, int coins) {
        if (i < 0 || j < 0 || i > 2 || j > m) return;
        
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
