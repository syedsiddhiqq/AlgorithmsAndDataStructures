package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 27-04-2022, Wednesday, 09:57
 */
public class CatFurrierTransformation {
    static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        double temp = Math.log(n) / Math.log(2);
        return (int) (Math.ceil(temp)) ==
                (int) (Math.floor(temp));
    }

    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        if (isPowerOfTwo(n + 1)) {
            System.out.println(0);
        } else {
            double temp = Math.log(n) / Math.log(2);
            long powerOfTwo = (long) Math.pow(2, (int) temp) - 1;
            char[] nStr = Integer.toBinaryString(n).toCharArray();
            char[] powerOfTwoStr = Long.toBinaryString(powerOfTwo).toCharArray();

            StringBuilder sb = new StringBuilder();
            int a = nStr.length - 1, b = powerOfTwoStr.length - 1;
            while (a >= 0 && b >= 0) {
                if (powerOfTwoStr[b] == '1') {
                    if (nStr[a] == '0') {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                } else {
                    if (nStr[a] == '0') {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                }
                a--;
                b--;
            }

            while (a >= 0) {
                sb.append(nStr[a--]);
            }

            while(b >= 0){
                sb.append(powerOfTwoStr[b--]);
            }

            System.out.println(2);
            System.out.println(Integer.parseInt(sb.reverse().toString(),2));
        }
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
