package CodeForces.contests.edu125;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 22-03-2022, Tuesday, 20:49
 */
public class XYSequence {

    private static Scanner s = new Scanner(System.in);

    private static void findXYSequence(){
        int n = s.nextInt();
        long b = s.nextLong(),x = s.nextLong(),y = s.nextLong(),sum = 0;
        List<Long> list = new ArrayList<>();
        list.add(0L);
        for(int i=1;i<=n;i++){
            long sumPlusX = list.get(i-1) + x;
            long sumMinusY = list.get(i-1) - y;
            if(sumPlusX <= b){
                sum += sumPlusX;
                list.add(sumPlusX);
            }else{
                sum += sumMinusY;
                list.add(sumMinusY);
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            findXYSequence();
        }
    }
}
