package CodeForces.contests.contest783Div2;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 19-04-2022, Tuesday, 21:10
 */
public class SocialDistance {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++) arr[i]  = s.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        if( n > m){
            System.out.println("No");
        }else{
            long chairs = (arr[0] * 2) + n;
            for(int i=1;i<n -1;i++){
                chairs += arr[i];
            }

            if(chairs <= m){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
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
