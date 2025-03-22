package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-04-2022, Saturday, 12:24
 */
public class BankNotes {
    private static Scanner s = new Scanner(System.in);

    private static long binPow(long a, long b) {
        if (b == 0)
            return 1;
        long res = binPow(a, b / 2);
        if (b % 2 == 1)
            return res * res * a;
        else
            return res * res;
    }

    private static class Pair {
        long value;
        long minPower;
        long chosen = 9;

        public Pair(long value, long minPower) {
            this.value = value;
            this.minPower = minPower;
        }
    }


    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) arr[i] = binPow(10, s.nextInt());

        Pair[] values = new Pair[100];

        int itr = 0;
        long temp = 0, start = 0, pow = 0, minPower = 0;
        while (start < k) {
            long powOfTen = binPow(10, pow++);
            temp = powOfTen * 9;
            minPower = 0;
            for (int i = 0; i < n; i++) {
                if (powOfTen >= arr[i]) {
                    minPower = arr[i];
                } else {
                    break;
                }
            }
            values[itr] = new Pair(temp / minPower, minPower);
            start += values[itr].value;
            itr++;
        }

//        System.out.println(start);

        --itr;
        while (start != k && itr >= 0) {
            long copy = start;
            copy -= values[itr].value;
            temp = binPow(10, String.valueOf(temp).length() - 1);
            boolean set = false;
            for (int i = 0; i <= 9 && copy < k; i++) {
                long x = (temp * i) / values[itr].minPower;
                if (x + copy > k) {
                    copy += x;
                    values[itr].chosen = i;
                    System.out.print(i);
                    set = true;
                    break;
                }
            }
            if(!set) System.out.print(0);
            temp = temp / 10;
            itr--;
            start = copy;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
