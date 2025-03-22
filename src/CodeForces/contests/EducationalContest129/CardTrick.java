package CodeForces.contests.EducationalContest129;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-05-2022, Monday, 20:27
 */
public class CardTrick {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = s.nextInt();

        int m = s.nextInt();
        int index = 0;
        for (int i = 0; i < m; i++) {
            int temp = s.nextInt();
            index += temp;
            if (index > n)
                index = index % n;
        }
        index = index + 1;
        System.out.println(index > n ? arr[index % n] : arr[index]);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
