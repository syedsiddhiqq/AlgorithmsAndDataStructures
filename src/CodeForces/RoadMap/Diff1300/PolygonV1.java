package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 17-04-2022, Sunday, 09:19
 */
public class PolygonV1 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            grid[i] = s.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    if((j + 1 < n && grid[i][j+1] == '1') || (j + 1 >= n) || (i + 1 < n && grid[i+1][j] == '1') || (i+1 >=n)) continue;
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
