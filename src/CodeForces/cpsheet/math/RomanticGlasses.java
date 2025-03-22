package CodeForces.cpsheet.math;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RomanticGlasses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), l = 0;
            long s = 0;
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) s += sc.nextInt();
                else s -= sc.nextInt();
                if (set.contains(s) || s == 0) l = 1;
                set.add(s);
            }
            System.out.println(l == 1 ? "YES" : "NO");
        }
    }
}
