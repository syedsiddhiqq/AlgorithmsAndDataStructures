package CodeForces.contests.codeforces780div3;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 31-03-2022, Thursday, 21:16
 */
public class GetAnEvenString {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            HashSet<Character> set = new HashSet<>();
            String s = sc.next();
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    res += set.size() - 1;
                    set.clear();
                } else {
                    set.add(s.charAt(i));
                }
            }
            System.out.println(res + set.size());
        }
    }
}
