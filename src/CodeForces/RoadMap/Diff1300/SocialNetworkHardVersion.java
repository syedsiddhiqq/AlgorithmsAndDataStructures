package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 03-04-2022, Sunday, 22:46
 */
public class SocialNetworkHardVersion {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        long[] arr = new long[n];

        Deque<Long> dq = new LinkedList<>();
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (!set.contains(arr[i])) {
                if (set.size() >= k) {
                    set.remove(dq.pollLast());
                }
                dq.addFirst(arr[i]);
                set.add(arr[i]);
            }
        }
        System.out.println(set.size());
        while (!dq.isEmpty()) {
            System.out.print(dq.pollFirst() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solve();
    }
}
