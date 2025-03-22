package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 27-04-2022, Wednesday, 08:50
 */
public class AlarmClocksEverywhere {
    private static Scanner s = new Scanner(System.in);

    private static Long gcd(Long a, Long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        Long[] arr = new Long[n];
        List<Long> diff = new ArrayList<>();
        Long gcd = 1L;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            if (i == 0) continue;
            Long temp = arr[i] - arr[i - 1];
            if (i == 1) gcd = temp;
            else gcd = gcd(gcd, temp);
            diff.add(temp);
        }

        Long[] pArr = new Long[m];

        Map<Long, Integer> index = new HashMap<>();
        for (int i = 0; i < m; i++) {
            pArr[i] = s.nextLong();
            index.put(pArr[i], i);
        }

        while (gcd >= 1) {
            if (index.containsKey(gcd)) {
                System.out.println("YES");
                Long temp = arr[0] - gcd;
                System.out.println(temp > 0 ? temp : arr[0] + " " + (index.get(gcd) + 1));
                return;
            } else {
                for (int i = 0; i < diff.size(); i++) {
                    diff.set(i, diff.get(i) / gcd);
                }
                gcd = diff.get(0);
                for (int i = 1; i < diff.size(); i++) {
                    gcd = gcd(gcd, diff.get(i));
                }
            }
            if (index.containsKey(gcd)) {
                System.out.println("YES");
                Long temp = arr[0] - gcd;
                System.out.println(temp > 0 ? temp : arr[0] + " " + (index.get(gcd) + 1));
                return;
            }
            if (gcd == 1) break;
        }
        System.out.println("NO");
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
