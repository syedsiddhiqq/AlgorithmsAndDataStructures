package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 20-05-2022, Friday, 21:48
 */
public class DigitMinimization {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        String str = s.next();
        char[] copy = str.toCharArray();
        char[] arr = str.toCharArray();

        int n = arr.length;
        if(n == 1) {
            System.out.println(arr);
            return;
        }
        Arrays.sort(arr);
        if (arr[n - 1] == copy[n - 1]) {
            System.out.println(arr[1]);
        }else{
            System.out.println(arr[0]);
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
