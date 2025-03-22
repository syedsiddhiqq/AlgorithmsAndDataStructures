package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 08-04-2022, Friday, 09:01
 */
public class DivisibleConfusion {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n + 1];

        for (int i = 1; i <= n; i++) arr[i] = s.nextLong();

        if (arr[1] % 2 == 0) {
            System.out.println("NO");
        } else {
            int b = n;
            while (b > 0) {
                if (arr[b] % (b + 1) != 0) {
                    b--;
                } else {
                    int indexFounded = b - 1;
                    while (indexFounded > 0) {
                        if (arr[indexFounded] % (indexFounded + 1) != 0) {
                            break;
                        }
                        indexFounded--;
                    }

                    if (indexFounded < 1) {
                        System.out.println("NO");
                        return;
                    }

                    while (b >= indexFounded) {
                        if (arr[b] % b != 0) {
                            b--;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (b <= 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
