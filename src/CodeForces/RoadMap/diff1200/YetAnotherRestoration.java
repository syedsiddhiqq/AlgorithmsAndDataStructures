package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 17-03-2022, Thursday, 16:54
 */
public class YetAnotherRestoration {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        long x = s.nextLong(), y = s.nextLong();


        long diff = y - x;

        List<Long> result = new ArrayList<>();
        result.add(x);
        result.add(y);
        for (int i = 1; i <= diff; i++) {
            long maxPossibleBetweenXandY = n - 2; // including y
            if(diff % i == 0 && (diff / i) - 1 <= maxPossibleBetweenXandY){
                // can fit elements inside x and y
                long betweenOneAndX = (x - 1)/ i;
                long betweenXandYFromI = diff / i - 1;
                long temp = x;
                if(betweenXandYFromI ==  n - 2){
                    // can be placed inside.
                    for(int j=0;j<betweenXandYFromI;j++){
                        temp+=i;
                        result.add(temp);
                    }
                }else if( betweenOneAndX + betweenXandYFromI >= n - 2){
                    // Inside x and y
                    for(int j=0;j<betweenXandYFromI;j++){
                        temp+=i;
                        result.add(temp);
                    }

                    // Inside 1 and x
                    temp = x;
                    long remaining = n - (betweenXandYFromI + 2);
                    for(int j=0;j < remaining;j++){
                        temp-=i;
                        result.add(temp);
                    }
                }else{
                    // Inside x and y
                    for(int j=0;j<betweenXandYFromI;j++){
                        temp+=i;
                        result.add(temp);
                    }

                    // Inside 1 and x
                    temp = x;
                    for(int j=0;j < betweenOneAndX;j++){
                        temp-=i;
                        result.add(temp);
                    }

                    temp = y;
                    for(int j=0;j< n - 2 - betweenOneAndX - betweenXandYFromI;j++){
                        temp+=i;
                        result.add(temp);
                    }
                }
                break;
            }
        }
        result.forEach(i->{
            System.out.print(i+" ");
        });
        System.out.println();
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
