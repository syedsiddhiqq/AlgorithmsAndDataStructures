package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 20-03-2022, Sunday, 09:36
 */
public class CommonPrefixes {
    private static Scanner s = new Scanner(System.in);

    private static void findCommonPrefixes() {
        int n = s.nextInt();

        char[] str = new char[200];
        for (int i = 0; i < 200; i++) str[i] = 'a';
        System.out.println(new String(str));
        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            str[a] = (str[a] == 'a') ? 'b' : 'a';
            System.out.println(new String(str));
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findCommonPrefixes();
        }
    }
}
