package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 21-03-2022, Monday, 08:34
 */
public class IceSkating {
    private static Scanner s = new Scanner(System.in);

    private static class Point{
        Integer x;
        Integer y;

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        int n = s.nextInt();

        Point[] points = new Point[n];

        for(int i=0;i<n;i++){
            int x = s.nextInt(), y = s.nextInt();
            points[i] = new Point(x,y);
        }
    }

}
