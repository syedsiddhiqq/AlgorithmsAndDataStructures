package CodeForces.RoadMap.diff1200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 12-03-2022, Saturday, 16:08
 */
public class DifferentialSorting {
    private static Scanner s = new Scanner(System.in);

    private static void solve(){
        int n = s.nextInt();
        int[] arr = new int[n];
        int[] copy = new int[n];


        for(int i=0;i<n;i++ ){
            copy[i] = arr[i] = s.nextInt();
        }

        if(arr[n-2] > arr[n-1]){
            System.out.println("-1");
            return;
        }

        Arrays.sort(copy);
        boolean sorted = true;
        for(int i=0;i<n;i++){
            if(arr[i] != copy[i]){
                sorted = false;
                break;
            }
        }

        if(sorted){
            System.out.println("0");
            return;
        }

        if(arr[n-1] >= 0){
            System.out.println(n-2);
            for(int i=1;i<=n-2;i++){
                System.out.println(i + " " + (n-1) + " " + (n));
            }
        }else{
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            solve();
        }
    }
}
