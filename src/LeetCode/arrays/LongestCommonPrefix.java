package LeetCode.arrays;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-04-2023, Sunday, 23:09
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int tempIndex = strs[i].indexOf(prefix);
            while ( tempIndex != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
                tempIndex = strs[i].indexOf(prefix);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] input = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(input));
    }
}
