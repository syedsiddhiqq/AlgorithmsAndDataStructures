package CodeForces.RoadMap.Diff1300;

import java.util.*;

/**
 * @author SyedAli
 * @createdAt 04-04-2022, Monday, 10:37
 */
public class PerformTheComboV1 {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt() + 1;
        char[] str = s.next().toCharArray();

        int[] arr = new int[m];
        int freq[] = new int[26];
        for (int i = 0; i < m - 1; i++) {
            arr[i] = s.nextInt();
        }
        arr[m - 1] = n;

        Arrays.sort(arr);

        int start = 0;
        for (int i = 0; i < m; i++) {
            while (start < arr[i]) {
                freq[str[start] - 97] += (m - i);
                start++;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(freq[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
