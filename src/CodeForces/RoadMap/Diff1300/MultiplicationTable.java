package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-04-2022, Saturday, 09:57
 */
public class MultiplicationTable {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[][] grid = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = s.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            System.out.print("1 ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
