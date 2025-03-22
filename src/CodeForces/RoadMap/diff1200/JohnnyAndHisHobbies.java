package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 20-03-2022, Sunday, 18:55
 */
public class JohnnyAndHisHobbies {
    private static Scanner s = new Scanner(System.in);

    private static void findXorSet() {
        int n = s.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(s.nextInt());
        }

        Collections.sort(arr);
        for (int k = 1; k <= 1024; k++) {
            List<Integer> newArr = new ArrayList<>();

            for (Integer val : arr) {
                newArr.add(val ^ k);
            }

            Collections.sort(newArr);

            if(arr.equals(newArr)){
                System.out.println(k);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            findXorSet();
        }
    }
}
