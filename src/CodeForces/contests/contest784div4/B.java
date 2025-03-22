package CodeForces.contests.contest784div4;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-04-2022, Thursday, 20:08
 */
public class B {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Integer[] arr = new Integer[n];

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer key : freq.keySet()) {
            if (freq.get(key) >= 3) {
                System.out.println(key);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
