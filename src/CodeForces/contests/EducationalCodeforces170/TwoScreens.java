package CodeForces.contests.EducationalCodeforces170;

import java.util.Scanner;

public class TwoScreens {

    private static void solve(String a, String b){
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        int i = 0, matches = 0, operations = 0;
        while(i < aArr.length && i < bArr.length){
            if(aArr[i] == bArr[i]) {
                matches++;
                i++;
                continue;
            }
            break;
        }
        if(matches > 0) operations += matches + 1;
        operations += (aArr.length - matches) + (bArr.length - matches);
        System.out.println(operations);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String a = sc.nextLine();
            String b = sc.nextLine();

            solve(a, b);
        }
    }
}
