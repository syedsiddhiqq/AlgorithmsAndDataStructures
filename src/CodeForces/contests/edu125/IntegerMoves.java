//package CodeForces.contests.edu125;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 22-03-2022, Tuesday, 20:26
 */
public class IntegerMoves {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            int x = s.nextInt(),y = s.nextInt();
            double temp = Math.sqrt((x * x) + (y * y));
            if(x == 0 && y == 0){
                System.out.println(0);
            }else if(temp % 1 == 0){
                System.out.println(1);
            }else{
                System.out.println(2);
            }
        }
    }
}
