package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 18-04-2022, Monday, 09:46
 */
public class Homecoming {
    private static Scanner s = new Scanner(System.in);

    private static class Pair {
        int sum;
        int index;

        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    private static void solve() {
        int a = s.nextInt(), b = s.nextInt(), p = s.nextInt();
        char[] str = s.next().toCharArray();

        int start = 0, n = str.length, sum = 0;
        List<Pair> pre = new ArrayList<>();
        while (start < n - 1) {
            if (str[start] == 'A') {
                while (++start < n - 1 && str[start] == 'A') continue;
                sum += a;
                Pair pair = new Pair(a, start);
                pre.add(pair);
            }

            if (str[start] == 'B') {
                while (++start < n - 1 && str[start] == 'B') continue;
                sum += b;
                Pair pair = new Pair(b, start);
                pre.add(pair);
            }
        }

        start = 0;
        int ans = 0;
        while (sum > p && start < pre.size()) {
            Pair pair = pre.get(start);
            sum -= pair.sum;
            ans = pair.index >= n ? ans + 1 : pair.index;
            start++;
        }
        System.out.println(ans + 1);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
