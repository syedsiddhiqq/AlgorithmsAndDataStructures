package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 25-03-2022, Friday, 09:05
 */
public class HungrySequence {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int mod = 5 * (int)(1e7);
        Boolean[] arr = new Boolean[mod];
        Arrays.fill(arr,true);
        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<=Math.sqrt(mod);i++){
            if(arr[i] == true){
                primes.add(i);
                if(primes.size() >= n) break;
                for(int j = i * i;j<mod;j = j+i){
                    arr[j] = false;
                }
            }
        }
        for (Integer prime : primes) {
            System.out.print(prime + " ");
        }
        System.out.println();
    }
}
