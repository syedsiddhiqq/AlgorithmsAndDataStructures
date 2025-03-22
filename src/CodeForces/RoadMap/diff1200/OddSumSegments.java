package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 27-03-2022, Sunday, 08:50
 */
public class OddSumSegments {
    private static Scanner s = new Scanner(System.in);

    private static long[] readlong(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }
        return arr;
    }

    private static Long[] readLong(int n) {
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }
        return arr;
    }


    private static int[] readint(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    private static Integer[] readInt(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void printList(Collection<?> collection) {
        for (Object o : collection) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    private static void solve() {
        int n = s.nextInt(), k = s.nextInt();
        long[] arr = readlong(n);

        int odd = 0;

        // count odds.
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                odd++;
            }
        }

        // find number of possible odds in a segment.
        int start = 1;
        while (odd / start > k) {
            start += 2;
        }

        int remainder = odd % start;

        // if remainder == 0 we will have odd/start possible segments or odd/start + 1 segments
        int possibleSegments = odd / start + (remainder == 0 ? 0 : 1);

        if (possibleSegments != k || (remainder != 0 && remainder % 2 == 0)) {
            System.out.println("NO");
        } else {
            int numberOfSegments = possibleSegments;
            List<Integer> result = new ArrayList<>();
            int itr = 0;

            // if remainder == 0 we will have odd/start segments.
            while (numberOfSegments-- > 0) {
                int numberOfOddsInSegment = start;
                while (itr < n) {
                    if (arr[itr] % 2 != 0) {
                        --numberOfOddsInSegment;
                        if (numberOfOddsInSegment == 0) {
                            result.add(itr + 1);
                            itr++;
                            break;
                        }
                    }
                    itr++;
                }
            }

            if (result.size() != k) {
                result.add(n);
            }
            System.out.println("YES");
            printList(result);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
