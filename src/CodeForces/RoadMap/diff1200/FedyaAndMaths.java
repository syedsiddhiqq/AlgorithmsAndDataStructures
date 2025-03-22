package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 29-03-2022, Tuesday, 08:45
 */
public class FedyaAndMaths {
    private static Scanner s = new Scanner(System.in);

//    private static long pow(int n, int power) {
//        long ans = 1;
//        while (power-- > 0) {
//            ans = (ans * n) % 10;
//        }
//        return ans;
//    }

    private static int[] two = {2, 4, 8, 6};
    private static int[] three = {3, 9, 7, 1};
    private static int[] four = {4, 6};

    private static void solve() {
        char[] str = s.next().toCharArray();
        Integer n = str[str.length - 1] - '0';
        long ans = n;
        ans += (n % 4 == 0 ? two[3] : two[(n % 4) - 1]);
        ans += (n % 4 == 0 ? three[3] : three[n % 4 - 1]);
        ans += (n % 2 == 0 ? four[1] : four[n % 2 - 1]);
        System.out.println(ans % 5);
    }

    public static void main(String[] args) {
        solve();
    }
}
