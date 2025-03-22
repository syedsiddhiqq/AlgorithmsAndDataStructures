package CodeForces.RoadMap.diff1200;

import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 14-03-2022, Monday, 23:13
 */
public class GrandmaCapaKnitsAScarf {

    private static Scanner s = new Scanner(System.in);

    private static int findCountOfDeletedChars(char[] str, char chosen, int start, int end) {
        int deletions = 0;
        while (start < end) {
            if (str[start] != str[end]) {
                if (str[start] == chosen) {
                    start++;
                } else if (str[end] == chosen) {
                    end--;
                } else {
                    return Integer.MAX_VALUE;
                }
                deletions++;
            } else {
                start++;
                end--;
            }
        }
        return deletions;
    }

    private static void solve() {
        int n = s.nextInt();
        char[] str = s.next().toCharArray();

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (str[i] != str[j]) {
                // found the un-matching point.
                // Need to figure out max of 2 chars at i and j.
                int minDeletions = Math.min(findCountOfDeletedChars(str, str[i], i, j),
                        findCountOfDeletedChars(str, str[j], i, j));
                System.out.println(minDeletions == Integer.MAX_VALUE ? -1 : minDeletions);
                return;
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
