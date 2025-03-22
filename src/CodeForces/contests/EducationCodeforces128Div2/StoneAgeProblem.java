package CodeForces.contests.EducationCodeforces128Div2;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 14-05-2022, Saturday, 15:58
 */
public class StoneAgeProblem {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), q = s.nextInt();

        long sum = 0, prevX = -1;
        Boolean updated = false;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            sum += arr[i];
        }

        StringBuilder sb = new StringBuilder();
        Map<Integer, Long> updatedMap = new HashMap<>();
        for (int i = 0; i < q; i++) {
            int type = s.nextInt();
            if (type == 1) {
                int index = s.nextInt() - 1;
                long x = s.nextLong();

                if (!updated) {
                    sum -= arr[index];
                    arr[index] = x;
                } else {
                    if (updatedMap.containsKey(index)) {
                        sum -= updatedMap.get(index);
                    } else {
                        sum -= prevX;
                    }
                    updatedMap.put(index,x);
                }
                sum += x;

            } else if (type == 2) {
                long x = s.nextLong();
                sum = x * n;
                prevX = x;
                updated = true;
                updatedMap = new HashMap<>();
            }
            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        solve();
        s.close();
        ;
    }
}
