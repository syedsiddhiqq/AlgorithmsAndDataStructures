package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 16-03-2022, Wednesday, 08:48
 */
public class MakeItGood {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        Stack<Integer> s = new Stack<>();

        int start = 0, end = n - 1;
        while (start <= end) {
            if (arr[start] < arr[end]) {
                if (!s.isEmpty() && s.peek() > arr[start]) {
                    s.clear();
                    end = n - 1;
                } else if (!s.isEmpty() && s.peek() <= arr[start]) {
                    s.push(arr[start]);
                    start++;
                } else {
                    s.push(arr[start]);
                    start++;
                }

            }else{
                if(!s.isEmpty() && s.peek() > arr[end]){
                    s.clear();
                    end = n - 1;
                    start++;
                }else if (!s.isEmpty() && s.peek() <= arr[end]) {
                    s.push(arr[end]);
                    end--;
                } else {
                    s.push(arr[end]);
                    end--;
                }
            }
        }

        System.out.println(n - s.size());
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
