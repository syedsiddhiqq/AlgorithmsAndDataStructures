package CodeForces.contests.div3contest787;

import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 05-05-2022, Thursday, 20:47
 */
public class DetectiveTask {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] str = s.next().toCharArray();

        int n = str.length;
        int oneIndex = 0, zeroIndex = n;

        for (int i = n - 1; i >= 0; i--) {
            if (str[i] == '0') {
                zeroIndex = i;
            }
        }

        for (int i = 0; i < zeroIndex; i++) {
            if (str[i] == '1') {
                oneIndex = i;
            }
        }

        zeroIndex = zeroIndex == n ? zeroIndex - 1 : zeroIndex;
        System.out.println((zeroIndex - oneIndex) + 1);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
