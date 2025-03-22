//package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 03-04-2022, Sunday, 19:39
 */
public class BigVovaV1 {
    private static Scanner s = new Scanner(System.in);

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        int gcd = Integer.MIN_VALUE, maxGcdIndex = -1;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (gcd < arr[i]) {
                gcd = arr[i];
                maxGcdIndex = i;
            }
        }
        visited[maxGcdIndex] = true;

        List<Integer> result = new ArrayList<>();
        result.add(gcd);
        for (int i = 1; i < n; i++) {
            int temp = Integer.MIN_VALUE;
            maxGcdIndex = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int tempGcd = gcd(gcd, arr[j]);
                    if (temp < tempGcd) {
                        temp = tempGcd;
                        maxGcdIndex = j;
                    }
                }
            }
            if (maxGcdIndex != -1) {
                gcd = temp;
                visited[maxGcdIndex] = true;
                result.add(arr[maxGcdIndex]);
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
