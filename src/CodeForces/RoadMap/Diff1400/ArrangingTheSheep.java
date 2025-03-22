package CodeForces.RoadMap.Diff1400;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 05-05-2022, Thursday, 09:41
 */
public class ArrangingTheSheep {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        String strInput = s.next();
        char[] str = strInput.toCharArray();

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (str[i] == '*') {
                indices.add(i);
            }
        }


        if(indices.size() > 0){
            int middleSheep = indices.size() / 2;

            long op = 0,index = indices.get(middleSheep);
            for (int i = middleSheep - 1; i >= 0; i--) {
                op += index - indices.get(i) - 1;
                index--;
            }


            middleSheep = indices.size() / 2;
            index = indices.get(middleSheep);
            for (int i = middleSheep + 1; i < indices.size(); i++) {
                op += indices.get(i) - index - 1;
                index++;
            }
            System.out.println(op);
        }else{
            System.out.println(0);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
