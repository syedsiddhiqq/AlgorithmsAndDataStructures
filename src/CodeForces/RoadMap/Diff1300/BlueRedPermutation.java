package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 10-04-2022, Sunday, 10:19
 */
public class BlueRedPermutation {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n];

        Set<Long> set = new HashSet<>();
        LinkedList<Long> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            if (arr[i] > 0 && arr[i] <= n) {
                if (!set.contains(arr[i])) {
                    set.add(arr[i]);
                } else {
                    list.add(arr[i]);
                }
            } else {
                list.add(arr[i]);
            }
        }

        char[] str = s.next().toCharArray();
        int b = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == 'B') b++;
            else r++;
        }

        int total = (b + r) - set.size();
        for (long i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                if (total > 0) {
                    long topVal = list.pollFirst();
                    if (topVal > i) {
                        if (b > 0) {
                            b--;
                        } else {
                            System.out.println("NO");
                            return;
                        }
                    } else {
                        if (r > 0) {
                            r--;
                        } else {
                            System.out.println("NO");
                            return;
                        }
                    }
                    total--;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
