package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 10-04-2022, Sunday, 08:54
 */
public class ChatBan {
    private static Scanner s = new Scanner(System.in);

    private static long bSearch(long low, long high, long x) {
        while (low <= high) {
            long mid = (low + high) / 2;
            long messages = (mid * (mid + 1)) / 2;
            if (messages < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


    private static long reverseBSearch(long high, long low, long x, long k) {
        if (high == 0) return 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long messages = k - ((mid - 1) * mid) / 2;
            if (messages < x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }

    private static void solve() {
        long k = s.nextLong(), x = s.nextLong();

        long maxEmotes = (k * (k + 1)) / 2;
        if (maxEmotes > x) {
            System.out.println(bSearch(1, k, x));
        } else {
            System.out.println(k + reverseBSearch(k - 1, 1, x - maxEmotes, ((k - 1) * k) / 2));
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}

