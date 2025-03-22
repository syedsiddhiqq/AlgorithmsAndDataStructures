package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 25-04-2022, Monday, 10:29
 */
public class PlusFromPicture {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = s.next().toCharArray();
        }

        int row = -1, col = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '*' && j - 1 >= 0 && grid[i][j - 1] == '*' &&
                            i + 1 < n && grid[i + 1][j] == '*' && j + 1 < m && grid[i][j + 1] == '*') {
                        row = i;
                        col = j;
                    }
                }
            }
        }

        if (row == -1 || col == -1) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '*' && (i != row && j != col)) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
