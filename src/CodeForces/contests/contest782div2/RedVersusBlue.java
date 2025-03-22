package CodeForces.contests.contest782div2;

import java.util.*;

/**
 * @author SyedAli
 * @createdAt 17-04-2022, Sunday, 20:03
 */
public class RedVersusBlue {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), r = s.nextInt(), b = s.nextInt();

        List<StringBuilder> sbs = new ArrayList<>();
        for (int i = 0; i < b + 1; i++) {
            StringBuilder sb = new StringBuilder();
            sbs.add(sb);
        }

        int start = 0;
        for (int i = 0; i < r; i++) {
            if (start < sbs.size()) {
                sbs.get(start).append("R");
                start++;
            } else {
                start = 0;
                sbs.get(start).append("R");
                start++;
            }
        }

        for (int i = 0; i < b; i++) {
            sbs.get(i).append("B");
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sbs.size(); i++) res.append(sbs.get(i));
        System.out.println(res);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
