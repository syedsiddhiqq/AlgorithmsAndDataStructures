package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-04-2022, Tuesday, 09:40
 */
public class BooksExchangeV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n + 1];
            boolean buf[] = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                if (buf[i]) continue;
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(i);
                int cur = arr[i];
                while (cur != i) {
                    buf[cur] = true;
                    set.add(cur);
                    cur = arr[cur];
                }
                for (int tt : set) {
                    arr[tt] = set.size();
                }
            }
            StringBuilder s = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                s.append((i == 1 ? "" : " ") + arr[i]);
            }
            System.out.println(s);
        }
    }
}
