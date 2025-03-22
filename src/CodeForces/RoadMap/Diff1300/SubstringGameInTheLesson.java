package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 23-04-2022, Saturday, 08:30
 */
public class SubstringGameInTheLesson {

    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        char[] str = s.next().toCharArray();
        char min = 'z';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            if (min > ch) {
                min = ch;
            }
            if (ch > min) {
                sb.append("Ann\n");
            } else {
                sb.append("Mike\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
