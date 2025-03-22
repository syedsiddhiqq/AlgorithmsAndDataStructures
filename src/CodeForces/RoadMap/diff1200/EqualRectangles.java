package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 28-03-2022, Monday, 22:54
 */
public class EqualRectangles {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Map<Integer, Integer> freq = new TreeMap<>();

        for (int i = 0; i < 4 * n; i++) {
            int temp = s.nextInt();
            if (freq.containsKey(temp)) {
                freq.put(temp, freq.get(temp) + 1);
            } else {
                freq.put(temp, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Integer key : freq.keySet()) {
            int count = freq.get(key);
            if (count % 2 == 1) {
                System.out.println("NO");
                return;
            }
            for (int j = 1; j <= count / 2; j++) {
                list.add(key);
            }
        }

        long area = 1;
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (i == 0 || j == n - 1) {
                area = list.get(i) * list.get(j);
            }
            long tempArea = list.get(i) * list.get(j);
            if (tempArea != area) {
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
    }
}
