package CodeForces.RoadMap.diff1200;

import java.util.*;

/**
 * @author SyedAli
 * @createdAt 20-03-2022, Sunday, 08:40
 */
public class PrincessAndPrice {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();


        int[] dVisitedArr = new int[n + 1];
        int[] pVisitedArr = new int[n + 1];

        List<Queue<Integer>> daughtersList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int k = s.nextInt();
            Queue<Integer> q = new PriorityQueue<>();
            for (int j = 0; j < k; j++) {
                q.offer(s.nextInt());
            }
            daughtersList.add(q);
        }

        for (int i = 0; i < n; i++) {
            Queue<Integer> q = daughtersList.get(i);
            while (!q.isEmpty()) {
                int prince = q.poll();
                if (pVisitedArr[prince] == 0) {
                    pVisitedArr[prince] = 1;
                    dVisitedArr[i + 1] = 1;
                    break;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dVisitedArr[i] != 1) {
                for (int j = 1; j <= n; j++) {
                    if (pVisitedArr[j] != 1) {
                        System.out.println("IMPROVE");
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }
        System.out.println("OPTIMAL");
    }

    public static void main(String[] args) {
        int t = s.nextInt();

        while (t-- > 0) {
            solve();
        }
    }
}
