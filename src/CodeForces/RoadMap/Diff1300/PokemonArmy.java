package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 04-04-2022, Monday, 08:57
 */
public class PokemonArmy {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), q = s.nextInt();
        int[] arr = new int[n];

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            ans = Math.max(ans, arr[i]);
        }

        boolean peak = true;
        long currSum = 0;
        for (int i = 1; i < n; i++) {
            if (peak) {
                if (arr[i] < arr[i - 1]) {
                    peak = false;
                    currSum += arr[i - 1];
                }
            } else {
                if (arr[i] > arr[i - 1]) {
                    peak = true;
                    currSum -= arr[i - 1];
                }
            }
        }

        if (peak) currSum += arr[n - 1];
        System.out.println(currSum);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
