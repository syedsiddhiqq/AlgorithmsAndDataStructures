package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 17-04-2022, Sunday, 11:30
 */
public class UnusualCompetitions {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        char[] str = s.next().toCharArray();
        int open = 0, closed = 0;

        for (int i = 0; i < n; i++) {
            if (str[i] == '(') open++;
            else closed++;
        }

        if (open != closed) {
            System.out.println(-1);
        } else {
            Stack<Character> st = new Stack<>();
            int ans = 0, i = 0;
            while (i < n) {
                char ch = str[i];
                if (st.isEmpty() && ch == '(') {
                    st.push(ch);
                    i++;
                } else if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
                    st.pop();
                    i++;
                } else if (!st.isEmpty() && ch == '(' && st.peek() == '(') {
                    st.push(ch);
                    i++;
                } else {
                    // Invalid scenario.
                    int j = i;
                    open = 0;
                    closed = 0;
                    do {
                        if (str[j] == '(') open++;
                        else closed++;
                        j++;
                    } while (open != closed && j < n);
                    ans += (j - i);
                    i = j;
                }
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
