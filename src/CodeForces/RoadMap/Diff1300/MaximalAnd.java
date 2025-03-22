package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 27-04-2022, Wednesday, 19:59
 */
public class MaximalAnd {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        Integer[] arr = new Integer[n];

        arr[0] = s.nextInt();
        int and = arr[0];
        for(int i=1;i<n;i++){
            arr[i] = s.nextInt();
            and = and & arr[i];
        }

        if(k == 0){
            System.out.println(and);
        }else if(k == n){
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
