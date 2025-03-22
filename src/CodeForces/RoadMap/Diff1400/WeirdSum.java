package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 28-04-2022, Thursday, 09:57
 */
public class WeirdSum {
    private static Scanner s = new Scanner(System.in);

    private static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static void solve() {
        int n = s.nextInt(), m = s.nextInt();
        long[][] grid = new long[n + 1][m + 1];

        Map<Long, List<Point>> map = new HashMap<>();

        long totalSum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long temp = s.nextInt();
                grid[i][j] = temp;
                if (map.containsKey(temp)) {
                    List<Point> points = map.get(temp);
                    points.add(new Point(i, j));
                    map.put(temp, points);
                } else {
                    List<Point> list = new ArrayList<>();
                    list.add(new Point(i, j));
                    map.put(temp, list);
                }
            }
        }

        for (List<Point> value : map.values()) {
            Collections.sort(value, Comparator.comparingInt(a -> a.i));

            long sum = 0;
            for (int i = 0; i < value.size(); i++) {
                sum += value.get(i).i;
            }

            for (int i = 0; i < value.size(); i++) {
                sum -= value.get(i).i;
                totalSum += (sum - (value.size() - 1 - i) * value.get(i).i);
            }

            Collections.sort(value, Comparator.comparingInt(a -> a.j));

            sum = 0;
            for (int i = 0; i < value.size(); i++) {
                sum += value.get(i).j;
            }

            for (int i = 0; i < value.size(); i++) {
                sum -= value.get(i).j;
                totalSum += (sum - (value.size() - 1 - i) * value.get(i).j);
            }
        }

        System.out.println(totalSum);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
