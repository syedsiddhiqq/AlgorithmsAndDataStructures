package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 26-04-2022, Tuesday, 08:54
 */
public class WowFactor {
    private static Scanner s = new Scanner(System.in);

    private static class Element {
        int countOfV = 0;
        int countOfO = 0;
        int prevO = -1;
    }

    private static void solve() {
        char[] str = s.next().toCharArray();
        int n = str.length;
        Element[] elements = new Element[n];

        int prev = -1;
        elements[n - 1] = new Element();
        if (str[n - 1] == 'v') elements[n - 1].countOfV++;
        else {
            elements[n - 1].countOfO++;
            prev = n - 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            elements[i] = new Element();
            elements[i].countOfV += elements[i + 1].countOfV;
            elements[i].countOfO += elements[i + 1].countOfO;
            elements[i].prevO = prev;
            if (str[i] == 'v') elements[i].countOfV++;
            else {
                elements[i].countOfO++;
                prev = i;
            }
        }

        int start = 0, ans = 0;
        while (start < n) {
            int nextIndexOfO = elements[start].prevO;
            if (nextIndexOfO > 0) {
                int countOfVBeforeO = elements[start].countOfV - elements[nextIndexOfO].countOfV;
                if (countOfVBeforeO >= 2) {
                    int currO = elements[start].prevO;
                    while (currO > 0 && currO < n) {
                        int countOfVAfterO = elements[currO].countOfV;
                        countOfVBeforeO = elements[0].countOfV - elements[currO].countOfV;
                        ans += (countOfVBeforeO - 1) * (countOfVAfterO - 1);
                        currO = elements[currO].prevO;
                    }
                    start = elements[start].prevO + 1;
                    continue;
                }
            }
            start++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
