package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 26-03-2022, Saturday, 19:10
 */
public class NextTest {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int[] arr = new int[5001];

        for(int i=0;i<n;i++){
            arr[s.nextInt()] = 1;
        }

        for(int i=1;i<=5001;i++){
            if(arr[i] == 0) {
                System.out.println(i);
                return;
            }
        }
    }
}
