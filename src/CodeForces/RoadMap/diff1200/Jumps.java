package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 19-03-2022, Saturday, 09:34
 */
public class Jumps {
    private static Scanner s = new Scanner(System.in);

    private static void solve(){
        long x = s.nextLong();

        int i=1;
        for(i=1;i<=x;i++){
            if((i * (i + 1)) >= 2 * x){
                break;
            }
        }

        if((i * (i + 1))/2 == x + 1){
            System.out.println(i + 1);
        }else{
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            solve();
        }
    }
}
