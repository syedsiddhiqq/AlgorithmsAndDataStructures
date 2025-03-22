package codechef.codechefstarters31;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-03-2022, Wednesday, 19:56
 */
public class A {

    private static Scanner s = new Scanner(System.in);

    private static void findPartner() {
        long n = s.nextLong(), x = s.nextLong();

        if (x <= n / 2) {
            System.out.println((2 * n) - (x - 1));
        } else {
            System.out.println(((2 * n) - x) + 1);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findPartner();
            ;
        }
    }
}
