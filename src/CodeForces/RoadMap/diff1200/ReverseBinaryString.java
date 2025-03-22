package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 22-03-2022, Tuesday, 08:51
 */
public class ReverseBinaryString {

    private static Scanner s = new Scanner(System.in);


    private static void reverseBinaryString() {
        int n = s.nextInt();
        int c = 0;
        String str = s.next();
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                c++;
            }
        }
        System.out.println((c + 1)/2);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            reverseBinaryString();
        }
    }
}
