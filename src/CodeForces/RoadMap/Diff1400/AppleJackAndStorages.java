package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 24-05-2022, Tuesday, 09:55
 */
public class AppleJackAndStorages {
    private static Scanner s = new Scanner(System.in);

    private static class Pair {
        Integer key;
        Integer count;
    }

    private static void solve() {
        int n = s.nextInt();
        Map<Integer, Pair> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer key = s.nextInt();

            if (freq.containsKey(key)) {
                Pair pair = freq.get(key);
                pair.count++;
            } else {
                Pair pair = new Pair();
                pair.key = key;
                pair.count = 1;
                freq.put(key, pair);
            }
        }

        int q = s.nextInt();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);

        while (q-- > 0) {
            char ch = s.next().toCharArray()[0];
            int x = s.nextInt();

            if (ch == '+') {
                if (freq.containsKey(x)) {
                    Pair pair = freq.get(x);
                    pair.count++;
                } else {
                    Pair pair = new Pair();
                    pair.key = x;
                    pair.count = 1;
                    freq.put(x, pair);
                }
            } else {
                freq.get(x).count--;
            }

            pq.addAll(freq.values());

            boolean square = false, rect = false, half = false;
            while (!pq.isEmpty()) {
                Pair pair = pq.poll();
                int count = pair.count;
                if (!square && count >= 4) {
                    square = true;
                    count = pair.count - 4;
                }

                if (!rect) {
                    if (count >= 4) {
                        rect = true;
                    } else if (count >= 2) {
                        if (half) {
                            rect = true;
                        } else {
                            half = true;
                        }
                    }
                }

                if (square && rect) {
                    break;
                }
            }

            if (square && rect) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
