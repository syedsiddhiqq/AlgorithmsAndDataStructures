package CodeForces.RoadMap.diff1200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 11-03-2022, Friday, 14:32
 */
public class GreatSequence {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        long x = s.nextLong();

        Map<Long, Integer> countMap = new HashMap<>();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            if (countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }

         Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (countMap.containsKey(arr[i]) && countMap.get(arr[i]) > 0) {
                long temp = arr[i] * x;
                if (countMap.containsKey(temp) && countMap.get(temp) > 0) {
                    countMap.put(arr[i], countMap.get(arr[i]) - 1);
                    countMap.put(temp, countMap.get(temp) - 1);
                }
            }
        }

        int ans = 0;
        for (Long key : countMap.keySet()) {
            ans += countMap.get(key);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
