package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 22-03-2022, Tuesday, 10:29
 */
public class NeighborGrid2 {
    private static Scanner s = new Scanner(System.in);

    private static void findGoodGrid() {
        int n = s.nextInt(), m = s.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.nextInt();
            }
        }

        boolean possible = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if ((i == 0 && j == 0) || (i == 0 && j == m - 1) ||
                            (i == n - 1 && j == 0) || (i == n - 1 && j == m - 1)) {
                        if (grid[i][j] > 2) possible = false;
                        else grid[i][j] = 2;
                    } else if (grid[i][j] > 3) {
                        possible = false;
                    } else {
                        grid[i][j] = 3;
                    }
                } else {
                    if (grid[i][j] > 4) {
                        possible = false;
                    } else {
                        grid[i][j] = 4;
                    }
                }
                if (!possible) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findGoodGrid();
        }
    }
}
