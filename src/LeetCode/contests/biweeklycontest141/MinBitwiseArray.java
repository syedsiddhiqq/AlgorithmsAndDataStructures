package LeetCode.contests.biweeklycontest141;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MinBitwiseArray {
    private static void sieveOfEratosthenes(boolean[] prime, int n) {
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }

    public static int[] minBitwiseArray(List<Integer> nums) {
        int size = nums.size();
        int[] result = new int[size];

        for(int i=0; i< size; i++){
            if(nums.get(i) == 2){
                result[i] = -1;
                continue;
            }

            for(int j= nums.get(i) / 2; j<=nums.get(i);j++){
                if((j | (j + 1)) == nums.get(i)){
                    result[i]= j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1000;
        boolean[] prime = new boolean[n + 1];
        sieveOfEratosthenes(prime, n);
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) primeList.add(i);
        }
        int[] result = minBitwiseArray(primeList);
        for(int i=0;i<result.length;i++){
            System.out.println("For " + (primeList.get(i)) +  " result is :: " + result[i]);
        }
    }
}
