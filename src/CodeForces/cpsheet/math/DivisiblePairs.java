package CodeForces.cpsheet.math;

import java.util.*;

public class DivisiblePairs {

    private static void findBeautifulPairs(long x, long y, long[] arr, int n) {
        long pairs = 0;
        Map<Long, Map<Long, Long>> pairsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long aModX = arr[i] % x;
            long bModX = x - aModX;
            long aModY = arr[i] % y;
            if (aModX == 0) {
                bModX = 0;
            }
            if (pairsMap.containsKey(bModX) && pairsMap.get(bModX).containsKey(arr[i] % y)) {
                Long pairCount = pairsMap.get(bModX).get(arr[i] % y);
                pairs += pairCount;
            }
            pairsMap.putIfAbsent(aModX, new HashMap<>());
            Map<Long, Long> yMap = pairsMap.get(aModX);
            yMap.putIfAbsent(aModY, 0L);
            yMap.put(aModY, yMap.getOrDefault(aModY, 0L) + 1);
        }
        System.out.println(pairs);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            findBeautifulPairs(x, y, arr, n);
        }
    }
}
