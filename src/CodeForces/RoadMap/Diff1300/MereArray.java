package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 15-04-2022, Friday, 09:10
 */
public class MereArray {
    private static Scanner s = new Scanner(System.in);

    private static class Element {
        Long val;
        Integer index;

        public Element(Long val, Integer index) {
            this.val = val;
            this.index = index;
        }
    }

    private static void swap(Long[] arr, int a, int b) {
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static void solve() {
        int n = s.nextInt();
        Long[] arr = new Long[n];
        long min = Long.MAX_VALUE;

        Element[] elements = new Element[n];
        boolean one = false;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            min = Math.min(arr[i], min);
            elements[i] = new Element(arr[i], i);
            if (arr[i] == 1) one = true;
        }

        if (one) {
            System.out.println("YES");
            return;
        }

        Arrays.sort(elements, (a, b) -> (int) (a.val - b.val));
        for (int i = 0; i < n; i++) {
            if (elements[i].val != arr[i]) {
                if (arr[i] % min != 0) {
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
        s.close();
    }
}
