package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 16-05-2022, Monday, 09:42
 */
public class AddToNeighbourAndRemove {
    private static Scanner s = new Scanner(System.in);

    private static Integer findOperations(LinkedList<Integer> list, int operations) {
        Integer max = Integer.MIN_VALUE;
        for (Integer i : list) {
            max = Math.max(max, i);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max) {
                int sumLeft = 0, sumRight = 0;
                List<Integer> indicesToRemove = new ArrayList<>();
                for (int j = i - 1; j >= 0 && list.get(j) != max; j--) {
                    sumLeft += list.get(j);
                    indicesToRemove.add(list.get(j));
                }

                if (sumLeft > 0 && sumLeft % max == 0) {
                    operations += indicesToRemove.size() - 1;
                    list.removeAll(indicesToRemove);
                } else {
                    if (sumLeft > 0) {
                        list.set(i - 1, sumRight);
                        if (indicesToRemove.size() == 1) {
                            list.set(i, list.get(i) + list.get(i - 1));
                        }
                    }
                    list.removeAll(indicesToRemove);
                }
            }
        }

        if (list.size() != 0) {
            operations += findOperations(list, operations);
        }
        return operations;
    }

    private static void solve() {
        int n = s.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) list.add(s.nextInt());

        System.out.println(findOperations(list, 0));
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
