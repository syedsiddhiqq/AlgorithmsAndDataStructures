package LeetCode.dp;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 03-07-2022, Sunday, 14:43
 */
public class NthUglyNumber {
    public static int nthUglyNumber(int n) {
        int start = 1;
        while(n > 1){
            start++;
            if(start % 2 == 0 || start % 3 == 0 || start % 5 == 0){
                n--;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        nthUglyNumber(10);
    }
}
