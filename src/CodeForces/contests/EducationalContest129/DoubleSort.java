package CodeForces.contests.EducationalContest129;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-05-2022, Monday, 20:42
 */
public class DoubleSort {
    private static Scanner s = new Scanner(System.in);

    private static class Pair {
        Integer a;
        Integer b;
        Integer index;
    }

    private static void solve() {
        int n = s.nextInt();
        Pair[] pairs = new Pair[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.a < b.a) {
                return -1;
            }

            if (a.a == b.a) {
                return a.b - b.b;
            }

            return 1;
        });

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair();
            pairs[i].a = s.nextInt();
            pairs[i].index = i;
        }

        for (int i = 0; i < n; i++) {
            pairs[i].b = s.nextInt();
        }

        for (int i = 0; i < n; i++) pq.offer(pairs[i]);


        StringBuilder sb = new StringBuilder();
        int moves = 0;
        for (int i = 0; i < n && !pq.isEmpty(); i++) {
            Pair pair = pq.poll();
            if (pair.index == i) continue;
            moves++;
            sb.append((pair.index + 1) + " " + (i + 1) + "\n");
            pairs[i].index = pair.index;
            pairs[pair.index] = pairs[i];
            pairs[i] = pair;
            pair.index = i;
        }

        for (int i = 1; i < n; i++) {
            if (pairs[i-1].b > pairs[i].b) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(moves);
        System.out.print(sb);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
