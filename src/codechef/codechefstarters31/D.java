package codechef.codechefstarters31;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-03-2022, Wednesday, 20:48
 */
public class D {
    private static Scanner s = new Scanner(System.in);


    private static void solve() {
        long n = s.nextLong();
        long start = 0;
        int i = 0;
        double powOfTwo;
        while (true) {
            i++;
            powOfTwo = Math.pow(2, start);
            if (n < powOfTwo) {
                break;
            }
            start++;
        }
        System.out.println((long)(powOfTwo - start - (powOfTwo - n)));
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
