package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-04-2022, Saturday, 12:32
 */
public class Equalize {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        char[] a = s.next().toCharArray();
        char[] b = s.next().toCharArray();

        Queue<Integer> zeroes = new LinkedList<>();
        Queue<Integer> ones = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                if (a[i] == '0') {
                    zeroes.offer(i);
                } else {
                    ones.offer(i);
                }
            }
        }

        int ans = 0;
        while (!ones.isEmpty() && !zeroes.isEmpty()) {
            if (Math.abs(ones.peek() - zeroes.peek()) == 1) {
                ones.poll();
                zeroes.poll();
            } else if (ones.peek() <= zeroes.peek()) {
                ones.poll();
            } else {
                zeroes.poll();
            }
            ans++;
        }

        ans += ones.size();
        ans += zeroes.size();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}
