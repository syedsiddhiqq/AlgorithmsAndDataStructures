package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 13-04-2022, Wednesday, 10:13
 */
public class PlanetLapituletti {
    private static Scanner s = new Scanner(System.in);

    private static List<Integer> list = new ArrayList<>();

    private static List<String> invalids = Arrays.asList("3", "4", "6", "7", "9");

    private static int[] flips = {0, 1, 5, -1, -1, 2, -1, -1, 8, -1};

    private static boolean check(String i) {
        for (String invalid : invalids) {
            if (i.contains(invalid)) {
                return false;
            }
        }
        return true;
    }

    private static int upperBound(int x) {// x is the key or target value
        int l = -1, r = list.size();
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (list.get(m) <= x) l = m;
            else r = m;
        }
        return l + 1;
    }

    private static void pre() {
        for (int i = 0; i < 100; i++) {
            if (check(String.valueOf(i))) list.add(i);
        }
    }

    private static void solve() {
        int h = s.nextInt(), m = s.nextInt();
        String[] str = s.next().split(":");
        String reverseHStr = new StringBuilder(str[0]).reverse().toString();
        String reverseMStr = new StringBuilder(str[1]).reverse().toString();

        int givenH = Integer.parseInt(str[0]), givenM = Integer.parseInt(str[1]);
        int reverseM = Integer.parseInt(reverseHStr), reverseH = Integer.parseInt(reverseMStr);

        if (!list.contains(reverseH) || reverseH > h - 1) {
            // if given h is invalid
            int nextGreater = upperBound(givenH);
            if (nextGreater >= list.size() || list.get(nextGreater) > h - 1) {
                str[0] = "00";
            } else {
                str[0] = String.valueOf(list.get(nextGreater));
                if (str[0].length() == 1) {
                    str[0] = "0" + str[0];
                }
            }
        }

        if (!list.contains(reverseM) || reverseM > m - 1) {
            // if given m is invalid.
            int nextGreater = upperBound(givenM);
            if (nextGreater >= list.size() || list.get(nextGreater) > m - 1) {
                str[1] = "00";
            } else {
                str[1] = String.valueOf(list.get(nextGreater));
                if (str[1].length() == 1) {
                    str[1] = "0" + str[1];
                }
            }
        }
        System.out.println(str[0] + ":" + str[1]);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        pre();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
