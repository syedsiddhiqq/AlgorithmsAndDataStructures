package CodeForces.contests.EducationCodeforces128Div2;

import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 14-05-2022, Saturday, 15:07
 */
public class AvtoBus {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        Long n = s.nextLong();

        if (n <= 3) {
            System.out.println(-1);
        } else {
            if (n % 2 == 1) {
                System.out.println(-1);
            } else {
                Long noOfFour = 0L, noOfSix = 0L;
                Integer countFour = 0, countSix = 0;
                Long copy = n;

                while (n % 6 != 0) {
                    n -= 4;
                    countFour++;
                }
                noOfSix = n / 6;
                n = copy;

                while (n % 4 != 0) {
                    n -= 6;
                    countSix++;
                }
                noOfFour = n / 4;
                noOfFour += countSix;
                noOfSix += countFour;

                if (noOfFour == 0 || noOfSix == 0) {
                    long temp = Math.max(noOfFour, noOfSix);
                    System.out.println(temp + " " + temp);
                } else {
                    System.out.println(noOfSix + " " + noOfFour);
                }
            }
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            solve();
        }
        s.close();
    }
}
