package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 03-04-2022, Sunday, 20:54
 */
public class NegativePrefixes {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        Integer[] arr = new Integer[n];

        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int[] lockedInArr = new int[n];
        for (int i = 0; i < n; i++) {
            lockedInArr[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (lockedInArr[i] == 1) continue;
            if (arr[i] < 0) {
                negatives.add(arr[i]);
            } else {
                positives.add(arr[i]);
            }
        }

        Collections.sort(positives, Collections.reverseOrder());
        Collections.sort(negatives, Collections.reverseOrder());

        int positiveStart = 0, negativeStart = 0;
        for (int i = 0; i < n; i++) {
            if (lockedInArr[i] == 1) continue;
            if (positiveStart < positives.size()) {
                arr[i] = positives.get(positiveStart++);
                continue;
            }
            if (negativeStart < negatives.size()) {
                arr[i] = negatives.get(negativeStart++);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
