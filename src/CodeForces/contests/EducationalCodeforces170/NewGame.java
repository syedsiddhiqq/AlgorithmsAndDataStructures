package CodeForces.contests.EducationalCodeforces170;

import java.util.*;

public class NewGame {

    private static class Pair {
        long key;
        int value;

        public Pair(long key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static void solve(int n, int k, long[] cards) {
        Map<Long, Pair> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.putIfAbsent(cards[i], new Pair(cards[i], 0));
            freq.get(cards[i]).value++;
        }
        List<Pair> freqList = new ArrayList<>(freq.values());
        freqList.sort(Comparator.comparingLong(a -> a.key));
        long finalResult = freqList.get(0).value;
        long result = freqList.get(0).value;
        int currStart = 0, out = 0, in = 1;
        while (in < k && in < freqList.size()) {
            Pair currPair = freqList.get(in);
            Pair prevPair = freqList.get(in - 1);
            if (currPair.key - prevPair.key == 1) {
                result += currPair.value;
            } else {
                result = currPair.value;
                currStart = in;
            }
            finalResult = Math.max(finalResult, result);
            in++;
        }

        while (in < freqList.size()) {
            if (out > currStart || in - out >= k) {
                result -= freqList.get(out).value;
                currStart = out + 1;
            }

            Pair currPair = freqList.get(in);
            Pair prevPair = freqList.get(in - 1);
            if (currPair.key - prevPair.key == 1) {
                result += currPair.value;
            } else {
                result = currPair.value;
                currStart = in;
            }
            in++;
            out++;
            finalResult = Math.max(finalResult, result);
        }
        System.out.println(finalResult);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            long[] cards = new long[n];
            for (int i = 0; i < n; i++) {
                cards[i] = sc.nextLong();
            }
            solve(n, k, cards);
        }
    }
}
