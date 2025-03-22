package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 01-05-2022, Sunday, 09:15
 */
public class SubtleSubstringSubtraction {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] str = s.next().toCharArray();
        int n = str.length;
        if (n == 1) {
            System.out.println("Bob " + (str[0] - 'a' + 1));
        } else {
            if (n % 2 == 0) {
                int total = 0;
                for (int i = 0; i < n; i++) {
                    total += (str[i] - 'a') + 1;
                }
                System.out.println("Alice " + total);
            } else {
                if (str[0] > str[n - 1]) {
                    int total = 0;
                    for (int i = 0; i < n - 1; i++) {
                        total += (str[i] - 'a') + 1;
                    }

                    System.out.println("Alice " + (total - (str[n - 1] - 'a' + 1)));
                } else {
                    int total = 0;
                    for (int i = 1; i < n; i++) {
                        total += (str[i] - 'a') + 1;
                    }

                    System.out.println("Alice " + (total - (str[0] - 'a' + 1)));
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
