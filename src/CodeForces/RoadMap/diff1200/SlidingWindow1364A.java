package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 17-03-2022, Thursday, 08:17
 */
public class SlidingWindow1364A {
    private static Scanner s = new Scanner(System.in);

    private static void solve(){
        int n = s.nextInt();
        int x = s.nextInt();

        int[] arr = new int[n];
        int sum = 0;
        boolean allNumberNotDivisibleByx = true;
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
            sum += arr[i];
            if(arr[i] % x != 0) allNumberNotDivisibleByx = false;
        }

        if(allNumberNotDivisibleByx){
            System.out.println(-1);
        }else if(sum % x != 0){
            System.out.println(n);
        }else{
            int ans = Integer.MIN_VALUE;

            int copy = sum;
            for(int i=0;i<n;i++){
                copy -= arr[i];
                if(copy % x != 0){
                    ans = Math.max( n - i - 1, ans);
                    break;
                }
            }

            copy = sum;
            for(int i=n-1;i>=0;i--){
                copy -= arr[i];
                if(copy % x != 0){
                    ans = Math.max( i, ans);
                    break;
                }
            }
            System.out.println(ans);
        }

    }

    public static void main(String[] args) {
        Integer t = s.nextInt();

        while(t-->0){
            solve();
        }
    }
}
