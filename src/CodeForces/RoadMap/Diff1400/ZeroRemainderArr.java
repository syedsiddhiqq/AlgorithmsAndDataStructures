package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 28-05-2022, Saturday, 12:41
 */
public class ZeroRemainderArr {
    private static Scanner s = new Scanner(System.in);

    private static class Pair {
        Integer value;
        Integer diff;
        Integer div;

        public Pair(Integer value, Integer diff, Integer div) {
            this.value = value;
            this.diff = diff;
            this.div = div;
        }
    }

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = s.nextInt();

            int diff = temp % k == 0 ? 0 : (((temp / k) + 1) * k - temp);
            pairs.add(new Pair(temp, diff, (temp / k + 1)));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.diff - b.diff);
        pq.addAll(pairs);

        int operations = 0, x = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if(x == pair.diff) continue;
            if (x < pair.diff) {
                int temp = pair.diff - x;
                operations += temp;
                x+= temp + 1;
            } else {
                pair.diff = (pair.div + 1) * k - pair.value;
                pair.div++;
                pq.offer(pair);
            }
        }

        System.out.println(operations);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
