package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 18-03-2022, Friday, 08:54
 */
public class PalindromeGameB1 {
    private static Scanner s = new Scanner(System.in);

    private static void solve(){
        int n = s.nextInt();
        char[] str = s.next().toCharArray();

        int zeroes = 0;
        for(int i=0;i<n;i++){
            if(str[i] == '0') zeroes++;
        }

        if(zeroes == 1 || zeroes % 2 == 0){
            System.out.println("BOB");
        }else{
            System.out.println("ALICE");
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            solve();
        }
    }
}
