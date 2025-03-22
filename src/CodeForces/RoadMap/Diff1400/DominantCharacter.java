package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-04-2022, Saturday, 18:03
 */
public class DominantCharacter {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        char[] str = s.next().toCharArray();

        int start = 0, totalA = 0, totalB = 0, totalC = 0;

        for (int i = 0; i < n; i++) {
            if (str[i] == 'a') totalA++;
            else if (str[i] == 'b') totalB++;
            else totalC++;
        }


        while (start < n) {
            if (str[start] == 'a') {
                if (start + 1 < n && str[start + 1] == 'a') {
                    System.out.println("2");
                    return;
                }

                int c = 0, b = 0, a = 1;
                int itr = start + 1;
                while (itr < n) {
                    if (str[itr] == 'a') {
                        a++;
                        break;
                    }
                    c++;
                    b++;
                    itr++;
                }

                if (a >= 2 && c < 2 && b < 2) {
                    System.out.println(itr - start + 1);
                    return;
                }
                start = itr;
                continue;
            }
            start++;
        }

        if (totalA <= 1 || totalA < totalB || totalA < totalC)
            System.out.println(-1);
        else
            System.out.println(n);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
