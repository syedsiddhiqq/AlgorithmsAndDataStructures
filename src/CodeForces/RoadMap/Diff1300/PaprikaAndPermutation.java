package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 09-04-2022, Saturday, 21:41
 */
public class PaprikaAndPermutation {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            long temp = s.nextLong();
            if (temp > n || set.contains(temp)) {
                pq.offer(temp);
            } else {
                set.add(temp);
            }
        }

        int operations = 0;
        for (Long i = 1L; i <= n; i++) {
            if (!set.contains(i)) {
                operations++;
                long smallest = pq.poll();
                if (smallest % (smallest - i) != i) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(operations);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
