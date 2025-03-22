package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 15-04-2022, Friday, 10:01
 */
public class PrefixFlipEasyVersion {
    private static Scanner s = new Scanner(System.in);

    private static void flipAndReverse(char[] str, int start, int end) {
        while (start <= end) {
            char temp = str[start] == '0' ? '1' : '0';
            str[start] = str[end] == '0' ? '1' : '0';
            str[end] = temp;
            start++;
            end--;
        }
    }

    private static void solve() {
        int n = s.nextInt();
        char[] a = s.next().toCharArray();
        char[] b = s.next().toCharArray();


        List<Integer> indices = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] != b[i]) {
                if (a[0] == b[i]) {
                    indices.add(1);
                    flipAndReverse(a, 0, 0);
                }
                indices.add(i + 1);
                flipAndReverse(a, 0, i);
            }
        }
        System.out.print(indices.size() + " ");
        for (Integer index : indices) {
            System.out.print(index + " ");
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
