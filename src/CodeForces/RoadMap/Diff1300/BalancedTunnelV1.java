package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-04-2022, Thursday, 10:33
 */
public class BalancedTunnelV1 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        LinkedList<Integer> start = new LinkedList<>();
        LinkedList<Integer> end = new LinkedList<>();
        Set<Integer> fined = new HashSet<>();

        for (int i = 0; i < n; i++) {
            start.add(s.nextInt());
        }

        for (int i = 0; i < n; i++) {
            end.add(s.nextInt());
        }

        while (!start.isEmpty() && !end.isEmpty()) {
            if (fined.contains(start.peekFirst())) {
                start.pollFirst();
            } else if (start.peekFirst() != end.peekFirst()) {
                fined.add(end.pollFirst());
            } else {
                start.pollFirst();
                end.pollFirst();
            }
        }
        System.out.println(fined.size());
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
