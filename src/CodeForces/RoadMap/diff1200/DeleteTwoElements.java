package CodeForces.RoadMap.diff1200;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 13-03-2022, Sunday, 12:08
 */
public class DeleteTwoElements {
    private static Scanner s = new Scanner(System.in);


    public static int[] readArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        return arr;
    }

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n];

        long sum = 0;
        Map<Long, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            sum += arr[i];
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            } else {
                freqMap.put(arr[i], 1);
            }
        }

        if ((2 * sum) % n != 0) {
            System.out.println("0");
            return;
        }
        long twoSumByN = (2 * sum) / n;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long d = twoSumByN - arr[i];
           if(freqMap.containsKey(d) && freqMap.get(d) > 0)
               ans += freqMap.get(d);
            if(arr[i] == d) ans -= 1;
        }

        System.out.println(ans/2);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
