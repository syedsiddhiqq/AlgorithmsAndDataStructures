package CodeForces.cpsheet.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DivideAndEqualize {

    private static void divideAndEqualize(int[] arr, int n) {
        Map<Integer, Integer> factorsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            for (int factor = 2; factor * factor <= ele; factor++) {
                int count = 0;
                while (ele % factor == 0) {
                    count++;
                    ele = ele / factor;
                }
                factorsMap.putIfAbsent(factor, 0);
                factorsMap.put(factor, factorsMap.getOrDefault(factor, 0) + count);
            }
            if(ele > 1) {
                factorsMap.putIfAbsent(ele, 0);
                factorsMap.put(ele, factorsMap.getOrDefault(ele, 0) + 1);
            }
        }

        for (Integer value : factorsMap.values()) {
            if(value % n != 0){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            divideAndEqualize(arr, n);
        }
    }
}
