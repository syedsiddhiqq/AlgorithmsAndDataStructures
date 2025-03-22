package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 19-03-2022, Saturday, 13:48
 */
public class DistrictsConnection {
    private static Scanner s = new Scanner(System.in);

    private static class District{
        List<Integer> indices = new ArrayList<>();
        long key;

        District(long key){
            this.key = key;
        }
    }

    private static void solve() {
        int n = s.nextInt();
        long[] arr = new long[n];


        Map<Long, District> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            if (freq.containsKey(arr[i])) {
                District d = freq.get(arr[i]);
                d.indices.add(i+1);
            } else {
                District d = new District(arr[i]);
                d.indices.add(i+1);
                freq.put(arr[i], d);
            }
        }

        if (freq.size() == 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            List<Long> keys = new ArrayList<>(freq.keySet());
            District a = freq.get(keys.get(0));
            for (int i = 0; i < keys.size() - 1; i++) {
                District b = freq.get(keys.get(i + 1));
                for (Integer index : b.indices) {
                    System.out.println(a.indices.get(0) + " " + index);
                }
            }

            int count = freq.get(keys.get(0)).indices.size();
            if(count > 1){
                for (int i = 1; i < count; i++) {
                    System.out.println(freq.get(keys.get(keys.size() - 1)).indices.get(0) + " " + freq.get(keys.get(0)).indices.get(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
