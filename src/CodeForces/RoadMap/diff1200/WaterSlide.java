package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-03-2022, Monday, 21:28
 */
public class WaterSlide {
    private static Scanner s = new Scanner(System.in);

    private static void sortWaterSlide(){
        int n = s.nextInt();
        long[] arr = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = s.nextLong();
        }

        long toAdd = 0;
        for(int i=1;i<n;i++){
            arr[i] += toAdd;
            if(arr[i] < arr[i-1]){
                toAdd+= arr[i-1] - arr[i];
                arr[i] = arr[i-1];
            }
        }
        System.out.println(toAdd);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            sortWaterSlide();
        }
    }
}
