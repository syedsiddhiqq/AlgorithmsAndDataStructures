package CodeForces.contests.edu125;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 22-03-2022, Tuesday, 21:29
 */
public class BracketSequenceDeletion {
    private static Scanner s = new Scanner(System.in);

    private static boolean palindromeCheck(String s, int start, int end) {
        char[] str = s.toCharArray();
        for (int i = start, j = end - 1; i <= j; i++, j--) {
            if (str[i] != str[j]) return false;
        }
        return true;
    }

    private static void bracketDeletion() {
        int n = s.nextInt();
        String str = s.next();
        Map<String, String> cache = new HashMap<>();
        Map<String, Boolean> palindromeCache = new HashMap<>();
        String ans = bracketDeletionUtil(str, 0, 0, n, cache, palindromeCache);
        System.out.println(ans);
    }

    private static String append(int operations, int length) {
        return String.valueOf(operations + " " + length);
    }

    private static String bracketDeletionUtil(String str, int operations, int start, int end, Map<String, String> cache, Map<String, Boolean> palindromeCache) {
        // if str reached end of str.
        if (start == end - 1) return append(operations, 1);

        // check if entire string is deleted.
        if (str.length() == 0) return append(operations, 0);

        // check if entire str is palindrome
        if (palindromeCache.containsKey(str) && palindromeCache.get(str))
            return append(operations, 0);
        else {
            Boolean flag = palindromeCheck(str, start, end);
            palindromeCache.put(str, flag);
            if (flag) return append(operations, str.length());
        }

        // remove first 2 chars if they are palindrome or perfect
        String ansAfterRemoval = null;
        if (start + 1 < end && (str.charAt(start) == str.charAt(start + 1) || (str.charAt(start) == '(' && str.charAt(start + 1) == ')'))) {
            ansAfterRemoval = bracketDeletionUtil(str, operations + 1, start + 2, end, cache, palindromeCache);
        }
        String ansWithoutRemoval = bracketDeletionUtil(str, operations + 1, start + 1, end, cache, palindromeCache);

        if (ansAfterRemoval == null) {
            cache.put(str, ansWithoutRemoval);
        } else {
            String[] ansAfterRemovalArr = ansAfterRemoval.split("\\s+");
            String[] ansWithoutRemovalArr = ansWithoutRemoval.split("\\s+");
            cache.put(str, (Integer.valueOf(ansAfterRemovalArr[0]) < Integer.valueOf(ansWithoutRemovalArr[0]) ? ansAfterRemoval : ansWithoutRemoval));
        }

        return cache.get(str);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            bracketDeletion();
        }
    }
}
