package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 17-03-2022, Thursday, 15:10
 */
public class AccurateLee {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        char[] str = s.next().toCharArray();

        int ones, zeroes;
        ones = zeroes = 0;


        int endIndexOfZero = -1, startIndexOfone = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (str[i] == '0') {
                endIndexOfZero = i;
                for (int j = i; j >= 0; j--) {
                    if (str[j] == '1') {
                        ones++;
                        startIndexOfone = j;
                    } else {
                        zeroes++;
                    }
                }
                break;
            }
        }

        if (ones == 0 || zeroes == 0) {
            System.out.println(new String(str));
        } else {
            for (int i = endIndexOfZero; i > startIndexOfone; i--) {
                if (str[i] == '1') {
                    str[i] = '-';
                }
            }

            for (int i = startIndexOfone; i < endIndexOfZero; i++) {
                if (str[i] == '0') {
                    str[i] = '-';
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                if(str[i] !='-')
                    sb.append(str[i]);
            }

            System.out.println(sb.toString().replace("10","0"));
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
