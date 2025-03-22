package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-03-2022, Wednesday, 10:49
 */
public class GameWithString {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] str = s.next().toCharArray();
        Stack<Character> st = new Stack<>();

        boolean first = true;
        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            if (st.isEmpty()) st.push(ch);
            else {
                if (st.peek().equals(ch)) {
                    st.pop();
                    first = !first;
                } else {
                    st.push(ch);
                }
            }
        }

        System.out.println(first ? "No" : "Yes");
    }

    public static void main(String[] args) {
        solve();
    }
}
