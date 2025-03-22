package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 26-03-2022, Saturday, 09:24
 */
public class BagsOfPotatoes {

    private static Scanner s = new Scanner(System.in);

    private static void findValueOfPotatoX(){
        long y = s.nextLong(),k = s.nextLong(),n = s.nextLong();
        long start = y / k, maxPossibleX = n - y,temp = ++start * k;
        List<Long> values = new ArrayList<>();
        while(true){
            long diff = temp - y;
            if(diff<= maxPossibleX){
                values.add(diff);
            }else{
                break;
            }
            temp = ++start * k;
        }

        if(values.isEmpty()) System.out.println(-1);
        else{
            for (Long value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        findValueOfPotatoX();
    }
}
