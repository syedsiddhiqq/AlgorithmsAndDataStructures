package CodeForces.RoadMap.Diff1400;


import java.util.*;

/**
 * @author SyedAli
 * @createdAt 02-05-2022, Monday, 09:39
 */
public class WonderfulColoring2 {
    private static Scanner s = new Scanner(System.in);

    private static class Pair {
        Integer key;
        List<Integer> indices = new ArrayList<>();
        Integer count = 0;

        public Pair(Integer key) {
            this.key = key;
        }
    }

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        int[] arr = new int[n];
        Map<Integer, Pair> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (freq.containsKey(arr[i])) {
                Pair pair = freq.get(arr[i]);
                pair.indices.add(i);
                pair.count++;
            } else {
                Pair pair = new Pair(arr[i]);
                pair.indices.add(i);
                pair.count++;
                freq.put(arr[i], pair);
            }
        }

        List<Pair> values = new ArrayList<>();

    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
