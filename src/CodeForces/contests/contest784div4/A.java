//package CodeForces.contests.contest784div4;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-04-2022, Thursday, 19:51
 */
public class A {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        if (n <= 1399) {
            System.out.println("Division 4");
        } else if (n <= 1599) {
            System.out.println("Division 3");
        } else if (n <= 1899) {
            System.out.println("Division 2");
        } else {
            System.out.println("Division 1");
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
