package CodeForces.RoadMap.diff1200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 11-03-2022, Friday, 14:14
 */
public class SystemOfNestedSegments {

    private static Scanner s = new Scanner(System.in);

    private static class Point{
        int x;
        int w;
        int i;

        Point(int x, int w, int i){
            this.x =x;
            this.w = w;
            this.i = i;
        }
    }

    private static void solve(){
        int n = s.nextInt();
        int m = s.nextInt();


        Point[] points = new Point[m];
        for(int i=0;i<m;i++){
            points[i] = new Point(s.nextInt(),s.nextInt(),i+1);
        }

        Arrays.sort(points, (a,b) -> a.w - b.w);

        Point[] taken = new Point[2*n];
        for(int i=0;i<2*n;i++){
            taken[i] = points[i];
        }

        Arrays.sort(taken,(a,b)->a.x - b.x);

        int ans = 0;
        for(int i=0;i<2*n;i++){
            ans+= taken[i].w;
        }

        System.out.println(ans);
        for(int i=0,j=2*n-1;i<j;i++,j--){
            System.out.println(taken[i].i + " " + taken[j].i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            solve();
        }
    }
}
