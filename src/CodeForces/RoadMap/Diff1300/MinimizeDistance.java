package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 10-04-2022, Sunday, 20:53
 */
public class MinimizeDistance {
    private static Scanner sc = new Scanner(System.in);

    private static void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(x > 0){
                pos.add(x);
            }
            else if(x < 0){
                neg.add(-x);
            }
        }
        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg, Collections.reverseOrder());

        long ans = 0;
        for (int i = 0; i < pos.size(); i+=k) {
            ans+=(pos.get(i)*2);
        }

        for (int i = 0; i < neg.size(); i+=k) {
            ans+=(neg.get(i)*2);
        }

        pos.add(0);
        neg.add(0);
        ans-=Math.max(pos.get(0), neg.get(0));
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
