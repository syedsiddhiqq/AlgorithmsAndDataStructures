package Tuf.dp;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ShortestCommonSubsequence {
    public static String shortestSupersequence(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int aLen = aArr.length, bLen = bArr.length;
        int[][] dp = new int[aLen + 1][bLen + 1];
        int maxLcsCount = 0;
        StringBuilder sb = new StringBuilder();
        int[] indexCache = new int[bLen];
        for(int i=1;i<=aLen;i++){
            for(int j=1;j<=bLen;j++){
                if(aArr[i - 1] == bArr[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        int i = aLen, j = bLen;
        while(i > 0 && j > 0){
            if(dp[i][j - 1] == dp[i - 1][j]){
                if(aArr[i - 1] == bArr[j - 1]){
                    result.append(aArr[i - 1]);
                    i--;
                    j--;
                }else{
                    result.append(bArr[j - 1]);
                    j--;
                }
            }else if(dp[i][j - 1] > dp[i - 1][j]){
                result.append(bArr[j - 1]);
                j--;
            }else{
                result.append(aArr[i - 1]);
                i--;
            }
        }
        if(i > 0){
            for(int start = i;start >= 1;start--){
                result.append(aArr[start - 1]);
            }
        }else{
            for(int start = j;start >= 1;start--){
                result.append(bArr[start - 1]);
            }
        }
        String resultStr = result.reverse().toString();
        System.out.println(resultStr);
        return resultStr;


    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        System.out.println(shortestSupersequence("brute", "groot"));
    }
}
