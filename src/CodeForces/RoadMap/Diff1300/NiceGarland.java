package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 27-04-2022, Wednesday, 20:33
 */
public class NiceGarland {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        String str = s.next();

        String[] list = {"RGB", "RBG", "GBR", "GRB", "BRG", "BGR"};

        List<StringBuilder> sbs = new ArrayList<>();
        for (int i = 0; i < 6; i++) sbs.add(new StringBuilder());

        for (int i = 1; i <= n + 1; i += 3) {
            for (int j = 0; j < 6; j++) sbs.get(j).append(list[j]);
        }

        int[] count = new int[6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sbs.size(); j++) {
                StringBuilder sb = sbs.get(j);
                if (str.charAt(i) != sb.charAt(i)) {
                    count[j]++;
                }
            }
        }

        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < 6; i++) {
            if (min > count[i]) {
                min = count[i];
                minIndex = i;
            }
        }

        System.out.println(count[minIndex]);
        System.out.println(sbs.get(minIndex).substring(0, n));
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
