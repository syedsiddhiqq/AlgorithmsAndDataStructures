package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 30-05-2022, Monday, 10:42
 */
public class RationalLee {
    private static Scanner s = new Scanner(System.in);

    private static class Tuple {
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
    }

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        int[] arr = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            pq.add(arr[i]);
        }

        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            int temp = s.nextInt();
            freq.put(temp, freq.getOrDefault(temp, 0) + 1);
        }


        List<Tuple> tuples = new ArrayList<>();
        for (Integer key : freq.keySet()) {
            Integer count = freq.get(key);
            Tuple[][] tuplesArr = new Tuple[count][count];
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    Integer temp = pq.poll();
                    tuplesArr[j][i] = new Tuple();
                    tuplesArr[j][i].max = Math.max(temp, tuplesArr[j][i].max);
                    tuplesArr[j][i].min = Math.min(temp, tuplesArr[j][i].min);
                }
            }
            for (Tuple[] tuple : tuplesArr) {
                for (Tuple tuple1 : tuple) {
                    tuples.add(tuple1);
                }
            }
        }

        long ans = 0;
        for (Tuple tuple : tuples) {
            ans += tuple.max + tuple.min;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
