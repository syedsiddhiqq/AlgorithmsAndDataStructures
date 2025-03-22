package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 28-04-2022, Thursday, 22:24
 */

public class IncreasingSubArraySums {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            long[] best = new long[N + 1];
            Arrays.fill(best, -Long.MIN_VALUE);
            best[0] = 0;

            for (int i = 0; i < N; i++) {
                long sum = 0;
                for (int j = i; j < N; j++) {
                    sum += nums[j];
                    best[j - i + 1] = Math.max(best[j - i + 1], sum);
                }
            }

//			System.out.println(Arrays.toString(best));

            for (int k = 0; k <= N; k++) {
                long max = Long.MIN_VALUE;
                for (int i = 0; i <= N; i++) {
                    max = Math.max(max, best[i] + Math.min(k, i) * (long) x);
                }
                System.out.print(max + " ");
            }
            System.out.println();
        }
    }
}