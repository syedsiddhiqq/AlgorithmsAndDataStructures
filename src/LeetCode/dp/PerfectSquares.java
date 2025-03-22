package LeetCode.dp;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 03-07-2022, Sunday, 19:39
 */
public class PerfectSquares {
    public static int numSquares(int n) {
        int[] nums = new int[n + 1];

        for (int i = 2; i * i <= n; i++) {
            nums[i * i] = 1;
            for (int j = i * i; j * i <= n; j += (i * i)) {
                nums[j] = j / i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[i - 1] + 1;
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        numSquares(19);
    }
}
