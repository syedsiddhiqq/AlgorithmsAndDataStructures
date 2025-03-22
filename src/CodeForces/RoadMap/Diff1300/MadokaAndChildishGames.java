package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 09-04-2022, Saturday, 09:06
 */
public class MadokaAndChildishGames {
    private static Scanner s = new Scanner(System.in);

    private static String construct(int x1, int y1, int x2, int y2) {
        return ((x1 + 1) + " " + (y1 + 1) + " " + (x2 + 1) + " " + (y2 + 1));
    }

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        char[][] grid = new char[n][m];
        char[][] newGrid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = s.next().toCharArray();
            Arrays.fill(newGrid[i], '0');
        }

        List<String> result = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && newGrid[i - 1][j] == '0') {
                        newGrid[i][j] = '1';
                        result.add(construct(i - 1, j, i, j));
                    } else if (j - 1 >= 0 && newGrid[i][j - 1] == '0') {
                        newGrid[i][j] = '1';
                        result.add(construct(i, j - 1, i, j));
                    } else {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(newGrid[i]);
//        }

        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
