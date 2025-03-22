package LeetCode.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] words = {"jump", "run", "run", "jump", "run"};

        for (int i = 0; i < words.length; i++) {
            List<String> remainingWords = new ArrayList<>();
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    remainingWords.add(words[j]);
                }
            }

            System.out.println("Removing index " + i + ", LCP length: " + findLCP(remainingWords));
        }
    }

    public static int findLCP(List<String> words) {
        if (words.isEmpty()) return 0;
        String prefix = words.get(0);
        for (int i = 1; i < words.size(); i++) {
            prefix = commonPrefix(prefix, words.get(i));
            if (prefix.isEmpty()) break;
        }
        return prefix.length();
    }

    public static String commonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < minLength && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return str1.substring(0, i);
    }
}
