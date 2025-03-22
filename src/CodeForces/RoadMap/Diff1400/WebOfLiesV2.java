package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-05-2022, Monday, 11:26
 */
public class WebOfLiesV2 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < m; i++) {
            Integer u = s.nextInt(), v = s.nextInt();
            if (u > v) {
                map.put(v, map.getOrDefault(v, 0) + 1);
            } else {
                map.put(u, map.getOrDefault(u, 0) + 1);
            }
        }

        Integer u, v;
        int q = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int temp = s.nextInt();
            if (temp == 1) {
                u = s.nextInt();
                v = s.nextInt();

                if (u > v) {
                    map.put(v, map.getOrDefault(v, 0) + 1);
                } else {
                    map.put(u, map.getOrDefault(u, 0) + 1);
                }
            } else if (temp == 2) {
                u = s.nextInt();
                v = s.nextInt();

                if (u > v) {
                    int x = u;
                    u = v;
                    v = x;
                }

                if (map.containsKey(u)) {
                    int count = map.get(u);
                    count--;
                    if (count == 0) {
                        map.remove(u);
                    } else {
                        map.put(u, count);
                    }
                }
            } else if (temp == 3) {
                sb.append(n - map.size() + "\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
