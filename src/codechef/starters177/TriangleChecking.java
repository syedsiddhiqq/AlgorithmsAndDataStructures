package codechef.starters177;

import java.util.Scanner;

public class TriangleChecking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if(((a + b) > c) && ((b + c) > a) && ((a + c) > b)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
