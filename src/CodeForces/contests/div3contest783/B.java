package CodeForces.contests.div3contest783;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 02-05-2022, Monday, 20:00
 */
public class B {
    private static Scanner s = new Scanner(System.in);

    private static Map<String, Integer> map = new HashMap<>();

    private static void pre() {
        int count = 1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
                if (ch != ch1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ch);
                    sb.append(ch1);
                    map.put(sb.toString(), count++);
                }
            }
        }
    }

    private static void solve() {
       String n = s.next();
        System.out.println(map.get(n));
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
