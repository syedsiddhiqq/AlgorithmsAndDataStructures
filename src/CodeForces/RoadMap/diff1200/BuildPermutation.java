package CodeForces.RoadMap.diff1200;

import java.util.*;

/**
 * @author SyedAli
 * @createdAt 12-03-2022, Saturday, 17:50
 */
public class BuildPermutation {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (i + 1);
        }
        if (Math.abs(a - b) > 1 || (a + b) > n - 2)
            System.out.println("-1");
        else {
            if (a == b) {
                for (int i = 1; a > 0; i = i + 2) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    a--;
                }
            } else if (a > b) {
                for (int i = n - 1; a > 0; i = i - 2) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    a--;
                }
            } else {
                for (int i = 0; b > 0; i = i + 2) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    b--;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
