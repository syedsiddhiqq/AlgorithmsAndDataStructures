package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-03-2022, Wednesday, 08:29
 */
public class BookReading {
    private static Scanner s = new Scanner(System.in);

    private static void findNumberOfPagesDivisibleByM() {
        long n = s.nextLong(), m = s.nextLong();

        long[] firstTenArr = new long[11];

        long sum = 0;
        for (int i = 1; i <= 10; i++) {
            firstTenArr[i] = (i * m) % 10;
            sum += firstTenArr[i];
        }

        long nByM = n / m;
        long ans = (nByM / 10) * sum;
        for (int i = 1; i <= nByM % 10; i++)
            ans += firstTenArr[i];

        System.out.println(ans);

    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findNumberOfPagesDivisibleByM();
        }
    }
}
