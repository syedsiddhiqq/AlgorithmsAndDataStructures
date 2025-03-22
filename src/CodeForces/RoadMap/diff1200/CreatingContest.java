//package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 25-03-2022, Friday, 22:01
 */
public class CreatingContest {
    private static Scanner s = new Scanner(System.in);

    private static void findNumberOfContests() {
        int n = s.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }

        long ans = 1,count = 1;
        for(int i=1;i<n;i++){
            if(arr[i-1] * 2 >= arr[i]){
                count++;
                ans = Math.max(ans, count);
            }else{
                count = 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        findNumberOfContests();
    }
}
