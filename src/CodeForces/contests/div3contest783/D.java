package CodeForces.contests.div3contest783;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-05-2022, Monday, 20:57
 */
public class D {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Long[] arr = new Long[n];

        for (int i = 0; i < n; i++) arr[i] = s.nextLong();

        List<Long> list = new ArrayList<>();
        int start = 0;
        if (n % 2 == 1) {
            list.add(arr[0]);
            start = 1;
        }

        for (int i = start; i < n; i += 2) {
            if (arr[i] < arr[i + 1]) {
                list.add(arr[i]);
                list.add(arr[i + 1]);
            } else {
                list.add(arr[i + 1]);
                list.add(arr[i]);
            }
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (list.get(i) != arr[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
