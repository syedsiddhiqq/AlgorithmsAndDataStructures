package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 16-03-2022, Wednesday, 09:27
 */
public class SortedAdjacentDifferences {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Long[] arr = new Long[n+1];

        List<Long> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextLong();
        }

        Arrays.sort(arr,1,n+1);

        if (n % 2 == 0) {
            int i = n / 2;
            int j = i + 1;
            while (i >= 1 && j <= n) {
                result.add(arr[i]);
                result.add(arr[j]);
                i--;
                j++;
            }
        } else {
            int i = (n / 2) + 1;
            int j = i + 1;
            while (i >= 2 && j <= n) {
                result.add(arr[i]);
                result.add(arr[j]);
                i--;
                j++;
            }
            result.add(arr[1]);
        }
        result.forEach(i -> {
            System.out.print(i + " ");
        });
        System.out.println();
    }


    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
