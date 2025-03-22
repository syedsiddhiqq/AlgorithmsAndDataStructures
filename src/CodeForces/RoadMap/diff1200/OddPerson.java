package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-03-2022, Wednesday, 21:49
 */
public class OddPerson {
    private static Scanner s = new Scanner(System.in);

    private static void print(int n, Long[] arr){
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void solve() {
        int n = s.nextInt();
        Long[] arr = new Long[n];

        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            if (arr[i] % 2 == 0) even++;
            else odd++;
        }

        if(odd == 0 || even == 0){
            print(n, arr);
        }else{
            Arrays.sort(arr);
            print(n, arr);
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
