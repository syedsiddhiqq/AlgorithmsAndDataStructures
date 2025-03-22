package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 26-03-2022, Saturday, 10:15
 */
public class MakeThemEqual1154B {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(s.nextInt());
        }

        if (set.size() <= 3) {
            List<Integer> values = new ArrayList<>(set);
            if (values.size() == 3 && Math.abs(values.get(0) - values.get(1)) == Math.abs(values.get(2) - values.get(1))) {
                System.out.println(Math.abs(values.get(0) - values.get(1)));
            } else if (values.size() == 2) {
                int diff = Math.abs(values.get(0) - values.get(1));
                System.out.println(diff % 2 == 0 ? diff / 2 : diff);
            } else if (values.size() == 1) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }
        System.out.println(-1);
    }
}
