package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 17-04-2022, Sunday, 10:35
 */
public class AliceBobAndCandies {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        LinkedList<Integer> list = new LinkedList<>();
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }

        int prevSum = 0, alice = 0, bob = 0, operations = 0;
        while (!list.isEmpty()) {
            // Alice
            int sum = 0;
            if (!list.isEmpty()) operations += 1;
            while (!list.isEmpty() && sum <= prevSum) {
                int candy = list.removeFirst();
                alice += candy;
                sum += candy;
            }

            // Bob.
            prevSum = sum;
            sum = 0;
            if (!list.isEmpty()) operations += 1;
            while (!list.isEmpty() && sum <= prevSum) {
                int candy = list.removeLast();
                bob += candy;
                sum += candy;
            }
            prevSum = sum;
        }
        System.out.println(operations + " " + alice + " " + bob);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
