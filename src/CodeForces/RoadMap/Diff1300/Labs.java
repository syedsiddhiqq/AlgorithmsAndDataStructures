package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 22-04-2022, Friday, 09:30
 */
public class Labs {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) list.add(new ArrayList<>());

        int start = 1;
        while (start <= n * n) {
            for (int i = 0; i < n && start <= n * n; i++) {
                list.get(i).add(start++);
            }

            for (int i = n - 1; i >= 0 && start <= n * n; i--) {
                list.get(i).add(start++);
            }
        }

        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
