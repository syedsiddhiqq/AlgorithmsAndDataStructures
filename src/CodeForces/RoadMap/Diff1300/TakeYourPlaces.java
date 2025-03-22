package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 13-04-2022, Wednesday, 08:58
 */
public class TakeYourPlaces {
    private static Scanner s = new Scanner(System.in);

    private static void swap(long[] arr, int a, int b) {
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n + 1];

        for (int i = 1; i <= n; i++) arr[i] = s.nextLong();

        int operations = 0;
        for (int i = 2; i <= n; i++) {
            int j = i + 1;
            int k = i - 1;
            if (arr[i] % 2 == 0 && arr[i - 1] % 2 == 0) {
                while (j <= n || k >= 1) {
                    if (j <= n && arr[j] % 2 == 1) {
                        break;
                    }

                    if (k >= 0 && arr[k] % 2 == 1) {
                        break;
                    }
                    j++;
                    k--;
                }
            } else if (arr[i] % 2 == 1 && arr[i - 1] % 2 == 1) {
                while (j <= n || k >= 1) {
                    if (j <= n && arr[j] % 2 == 0) {
                        break;
                    }

                    if (k >= 0 && arr[k] % 2 == 0) {
                        break;
                    }
                    j++;
                    k--;
                }
            } else continue;
            if (j > n && k > 1) {
                System.out.println("-1");
                return;
            }
            operations += (j - i);
            while (j > i) {
                swap(arr, j, j - 1);
                j--;
            }
        }
        System.out.println(operations);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
