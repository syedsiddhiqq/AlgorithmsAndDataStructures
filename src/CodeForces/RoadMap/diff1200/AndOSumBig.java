package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 20-03-2022, Sunday, 21:26
 */
public class AndOSumBig {
    private static Scanner s = new Scanner(System.in);

    private static void findNoOfArrays() {
        int n = s.nextInt(), k = s.nextInt();
        long ans = 1;
        for(int i=0;i<k;i++){
            ans = (ans * n) % (int)(1e9+7);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findNoOfArrays();
        }
    }
}
