package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 06-05-2022, Friday, 09:52
 */
public class PhoenixAndTowers {
    private static Scanner s = new Scanner(System.in);

    private static class Tower {
        Integer sum = 0;
        List<Integer> indices = new ArrayList<>();

        void toStringObj(StringBuilder sb) {
            for (int i = 0; i < indices.size(); i++) {
                sb.append(indices.get(i) + " ");
            }
        }
    }

    private static class Pair {
        Integer value;
        Integer index;

        public Pair(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }
    }

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt(), x = s.nextInt();

        LinkedList<Pair> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(s.nextInt(), i+1);
            list.add(pair);
        }

        Collections.sort(list, Comparator.comparingInt(a -> a.value));


        PriorityQueue<Tower> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        for (int i = 0; i < m; i++) {
            pq.add(new Tower());
        }

        boolean flag = true;
        while (!list.isEmpty()) {
            if (flag) {
                // smallest
                for (int i = 0; i < m && !list.isEmpty(); i++) {
                    Tower smallest = pq.poll();
                    Pair pair = list.pollFirst();
                    smallest.sum += pair.value;
                    smallest.indices.add(pair.index);
                    pq.offer(smallest);
                }
                flag = false;
            } else {
                // largest
                for (int i = 0; i < m && !list.isEmpty(); i++) {
                    Tower smallest = pq.poll();
                    Pair pair = list.pollLast();
                    smallest.sum += pair.value;
                    smallest.indices.add(pair.index);
                    pq.offer(smallest);
                }
                flag = true;
            }
        }

        List<Tower> towers = new ArrayList<>(pq);
        Collections.sort(towers, Comparator.comparingInt(a -> a.sum));

        StringBuilder sb = new StringBuilder();
        towers.get(0).toStringObj(sb);
        for (int i = 1; i < towers.size(); i++) {
            if (towers.get(i).sum - towers.get(i - 1).sum > x) {
                System.out.println("NO");
                return;
            }
           towers.get(i).toStringObj(sb);
        }
        System.out.println("YES");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
