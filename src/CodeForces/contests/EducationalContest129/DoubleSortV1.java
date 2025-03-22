package CodeForces.contests.EducationalContest129;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-05-2022, Monday, 20:58
 */
public class DoubleSortV1 {
    private static Scanner s = new Scanner(System.in);

    private static class Pair {
        Integer a;
        Integer b;
        Integer index;
    }

    private static void solve() {
        int n = s.nextInt();
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Pair pair = new Pair();
            pair.a = s.nextInt();
            pair.index = i;
            list.add(pair);
        }

        for (int i = 0; i < n; i++) {
            list.get(i).b = s.nextInt();
        }

        Collections.sort(list, (a, b) -> {
            if (a.a < b.a) {
                return -1;
            }

            if (a.a == b.a) {
                return a.b - b.b;
            }

            return 1;
        });

        for (int i = 1; i < n; i++) {
            if (list.get(i - 1).b > list.get(i).b) {
                System.out.println(-1);
                return;
            }
        }


    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
