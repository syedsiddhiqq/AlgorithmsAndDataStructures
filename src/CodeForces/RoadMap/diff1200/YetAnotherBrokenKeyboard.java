package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 17-03-2022, Thursday, 22:04
 */
public class YetAnotherBrokenKeyboard {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt(),k = s.nextInt();
        char[] str = s.next().toCharArray();
        List<Character> chars = new ArrayList<>();
        for(int i=0;i<k;i++){
            chars.add(s.next().charAt(0));
        }

        long count = 0,ans = 0;
        for(int i=0;i<n;i++){
            if(chars.contains(str[i])){
                count++;
            }else{
                ans = ans +  ((count * (count + 1))/2);
                count = 0;
            }
        }

        ans = ans +  ((count * (count + 1))/2);
        System.out.println(ans);
    }

}
