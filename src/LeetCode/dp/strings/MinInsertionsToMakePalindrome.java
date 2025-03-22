package LeetCode.dp.strings;

public class MinInsertionsToMakePalindrome {
    public static int minInsertion(String str) {
        return str.length() - lcs(str, reverseString(str));
    }

    public static int lcs(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    public static String reverseString(String input) {
        char[] str = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
