package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 19-03-2022, Saturday, 22:27
 */
public class BuildingPermutation {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        Long[] arr = new Long[n];

        for (int i = 0; i < n; i++) arr[i] = s.nextLong();

        Arrays.sort(arr);


        long ans = 0;
        for (int itr = 0; itr < n; itr++) {
            int i = itr+1;
            if (arr[itr] != i) {
                if (arr[itr] < 0) {
                    ans += ((-1 * arr[itr]) + i);
                } else if (arr[itr] == 0) {
                    ans += i;
                } else if (i < arr[itr]) {
                    ans += (arr[itr] - i);
                } else {
                    ans += (i - arr[itr]);
                }
            }
        }
        System.out.println(ans);
    }
}
