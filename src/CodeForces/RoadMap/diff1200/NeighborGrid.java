package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 22-03-2022, Tuesday, 09:50
 */
public class NeighborGrid {

    private static Scanner s = new Scanner(System.in);

    private static void findGoodGrid() {
        int n = s.nextInt(), m = s.nextInt();

        int[][] grid = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) continue;
                int count = 0;
                if (j - 1 >= 0 && grid[i][j - 1] > 0) count++;
                if (i - 1 >= 0 && grid[i - 1][j] > 0) count++;
                if (i + 1 < n && grid[i + 1][j] > 0) count++;
                if (j + 1 < m && grid[i][j + 1] > 0) count++;

                if (count < grid[i][j]) {
                    if (count > 0 && i - 1 >= 0) grid[i - 1][j]++;
                    if (count > 0 && j - 1 >= 0) grid[i][j - 1]++;
                    if (count > 0 && i + 1 < m) grid[i + 1][j]++;
                    if (count > 0 && j + 1 < n) grid[i][j + 1]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count = 0;
                if (j - 1 >= 0 && grid[i][j - 1] > 0) count++;
                if (i - 1 >= 0 && grid[i - 1][j] > 0) count++;
                if (i + 1 < n && grid[i + 1][j] > 0) count++;
                if (j + 1 < m && grid[i][j + 1] > 0) count++;
                if(count < grid[i][j]){
                    System.out.println("NO");
                    return;
                }
                grid[i][j] = count;
            }
        }

        System.out.println("YES");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
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
