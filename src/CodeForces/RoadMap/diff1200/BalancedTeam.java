package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 24-03-2022, Thursday, 22:55
 */
public class BalancedTeam {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        Long[] arr = new Long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }

        Arrays.sort(arr);

        int i = 0,j=0,ans = 0;
        while(j < n){
            if(arr[j] - arr[i] <= 5){
                int temp= (j - i) + 1;
                ans = Math.max(ans,temp);
                j++;
            }else{
                i++;
            }
        }
        System.out.println(ans);
    }
}

/*1 2 10 12 15 17*/