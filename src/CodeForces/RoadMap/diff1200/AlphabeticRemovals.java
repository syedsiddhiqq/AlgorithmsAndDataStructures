package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-03-2022, Wednesday, 21:57
 */
public class AlphabeticRemovals {
    private static Scanner s = new Scanner(System.in);

    private static class Element {
        Character ch;
        Queue<Integer> indices = new LinkedList<>();
        Integer count = 0;

        public Element(Character ch) {
            this.ch = ch;
        }
    }

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        Map<Character, Element> freq = new HashMap<>();
        char[] str = s.next().toCharArray();
        for (int i = 0; i < n; i++) {
            char ch = str[i];
            if (freq.containsKey(ch)) {
                Element ele = freq.get(ch);
                ele.indices.offer(i);
                ele.count++;
            }else{
                Element ele = new Element(ch);
                freq.put(ch, ele);
            }
        }

        for (int i = 0; i < 26 && k > 0; i++) {
            char ch = (char) ('a' + i);

        }
    }

    public static void main(String[] args) {
        solve();
    }
}
