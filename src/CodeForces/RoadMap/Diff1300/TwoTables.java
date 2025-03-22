package CodeForces.RoadMap.Diff1300;

import java.math.BigDecimal;
import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 07-04-2022, Thursday, 10:12
 */
public class TwoTables {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        long totalWidth = s.nextLong(), totalHeight = s.nextLong();
        long x1 = s.nextLong(), y1 = s.nextLong(), x2 = s.nextLong(), y2 = s.nextLong();
        long x3 = s.nextLong(), y3 = s.nextLong();

        double currentWidth = x2 - x1;
        double remainingWidth = totalWidth - currentWidth;

        double currentHeight = y2 - y1;
        double remainingHeight = totalHeight - currentHeight;

        Double widthAns = null;
        if (remainingWidth >= x3) {
            double fromLeft = x1 >= x3 ? 0 : Math.abs(x1 - x3);
            double fromRight = totalWidth - x2 >= x3 ? 0 : Math.abs((totalWidth - x2) - x3);

            widthAns = Math.min(fromRight, fromLeft);
        }

        Double heightAns = null;
        if (remainingHeight >= y3) {
            double fromBottom = y1 >= y3 ? 0 : Math.abs(y1 - y3);
            double fromTop = totalHeight - y2 >= y3 ? 0 : Math.abs((totalHeight - y2) - y3);

            heightAns = Math.min(fromBottom, fromTop);
        }

        if (heightAns == null && widthAns == null) {
            System.out.println(-1);
        } else if (widthAns == null) {
            System.out.println(BigDecimal.valueOf(heightAns).setScale(9));
        } else if (heightAns == null) {
            System.out.println(BigDecimal.valueOf(widthAns).setScale(9));
        } else {
            System.out.println(Math.min(BigDecimal.valueOf(heightAns).setScale(9).doubleValue(), BigDecimal.valueOf(widthAns).setScale(9).doubleValue()));
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
