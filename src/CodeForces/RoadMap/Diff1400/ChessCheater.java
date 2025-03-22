package CodeForces.RoadMap.Diff1400;

import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 19-05-2022, Thursday, 09:20
 */
public class ChessCheater {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        char[] games = s.next().toCharArray();


        int i = 0, ans = 0, j = -1, count = -1, prev = -1, finalPrev = -1, finalLast = -1;
        while (k > 0 &&  i < n && j < n) {
            count = count == -1 ? games[i] == 'L' ? 1 : 0 : count;
            j = j == -1 ? i + 1 : j + 1;
            prev = games[i] == 'L' ? i : -1;
            while (j < n) {
                if (games[j] == 'L') {
                    if (prev == -1) prev = j;
                    count++;
                    if (count > k) {
                        break;
                    }
                }
                j++;
            }
            int temp = 2 * (j - i) - 1;
            if (count > 0 && ans < temp) {
                ans = temp;
                finalPrev = i;
                finalLast = j;
            }
            i = prev + 1;
            count--;
        }

        for (i = 0; i < n; i++) {
            if (i >= finalPrev && i <= finalLast) continue;

            if (i - 1 >= 0 && games[i - 1] == 'W' && games[i] == 'W') ans += 2;
            else if (games[i] == 'W') ans++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
