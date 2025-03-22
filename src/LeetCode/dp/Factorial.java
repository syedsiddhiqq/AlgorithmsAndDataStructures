package LeetCode.dp;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 01-04-2023, Saturday, 18:11
 */
public class Factorial {

    private static int countTrailingZeroes(BigInteger i){
        int count = 0;
        while(i.compareTo(new BigInteger("0")) > 0 && i.mod(new BigInteger("10")).compareTo(new BigInteger("0")) == 0){
            i = i.divide(new BigInteger("10"));
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        BigInteger[] dp = new BigInteger[10000];
        dp[1] = new BigInteger("1");
        for(int i=2;i <= 200;i++){
            dp[i] = dp[i - 1].multiply(new BigInteger(String.valueOf(i)));
            System.out.println(i + " " + dp[i] + " " + countTrailingZeroes(dp[i]));
        }
    }
}
