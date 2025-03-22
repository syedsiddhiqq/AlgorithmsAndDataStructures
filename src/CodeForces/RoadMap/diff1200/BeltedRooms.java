package CodeForces.RoadMap.diff1200;

import java.util.*;

/**
 * @author SyedAli
 * @createdAt 29-03-2022, Tuesday, 10:32
 */
public class BeltedRooms {
    private static Scanner scanner = new Scanner(System.in);

    private static void solve() {
        int n = scanner.nextInt(), i, c = 0;
        String s = scanner.next();

        if (!s.contains(">") || !s.contains("<")) {
            c = n;
        } else {
            for (i = 0; i < n; i++)
                if (s.charAt(i) == '-' || s.charAt((i + 1) % n) == '-')
                    c++;
        }
        System.out.println(c);
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
