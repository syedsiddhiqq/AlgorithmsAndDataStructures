package codechef.starters177;

import java.util.Scanner;

public class TwoBoxes {

    private static int find2Boxes(int x, int y, int k){
        int x1 = x, y1 = y;
        int counter1 = 0, counter2 = 0;
        if( (x % 2 == 0 && y % 2 == 0 && k % 2 == 0) || (x % 2 != 0 && y % 2 != 0 && k % 2 == 0) || ((x % 2 != 0 || y % 2 != 0 ) && k % 2 == 1)){
            while( x1 >= 0 && y1 >= 0){
                if(Math.abs(x1 - y1 ) == k){
                    break;
                }
                x1++;
                y1--;
                counter1++;
            }
            x1 = x;
            y1 = y;
            while( x1 >= 0 && y1 >= 0){
                if(Math.abs(x1 - y1 ) == k){
                    break;
                }
                x1--;
                y1++;
                counter2++;
            }
            return Math.min(counter1, counter2);
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(find2Boxes(x, y, k));
        }
    }
}
