package CodeForces.RoadMap.diff1200;

import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 25-02-2022, Friday, 17:51
 */
public class AndrewAndStones {
    private static Scanner s = new Scanner(System.in);

    private static void solve(){
        int n = s.nextInt();
        long[] arr = new long[n];
        boolean possible = false;
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
            if(i != 0 && i !=n-1){
                if(arr[i] > 1){
                    possible = true;
                }
            }
        }

        long operations = 0;
        if(n == 3){
            if(arr[1] % 2 == 1){
                System.out.println("-1");
            }else{
                System.out.println(arr[1]/2);
            }
            return;
        }else if(!possible){
            System.out.println("-1");
            return;
        }else{
            for(int i=1;i<n-1;i++){
                if(arr[i] % 2 == 0){
                    operations+=arr[i]/2;
                }else{
                    operations+=(arr[i]+1)/2;
                }
            }
        }
        System.out.println(operations);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            solve();
        }
    }
}
