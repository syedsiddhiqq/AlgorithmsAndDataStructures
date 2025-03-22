package CodeForces.contests.EducationCodeforces128Div2;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 14-05-2022, Saturday, 11:25
 */
public class Robots {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = s.next().toCharArray();
        }


        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 'R') {
                    for (int k = j + 1; k < m; k++) {
                        for (int itr = 0; itr < i; itr++) {
                            if(grid[itr][k] == 'R'){
                                System.out.println("NO");
                                return;
                            }
                        }
                    }
                    System.out.println("YES");
                    return;
                }
            }
        }

    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
