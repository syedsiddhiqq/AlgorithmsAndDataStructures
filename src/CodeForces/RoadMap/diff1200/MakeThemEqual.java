package CodeForces.RoadMap.diff1200;

import java.util.Scanner;

/**
 * @author SyedAli
 * @createdAt 13-03-2022, Sunday, 14:51
 */
public class MakeThemEqual {
    private static Scanner s = new Scanner(System.in);

    private static void solve(){
        int n = s.nextInt();
        char c = s.next().toCharArray()[0];
        char[] str = s.next().toCharArray();

        int operations = 2;
        String ans = (n - 1 ) + " " + n;

        for(int i=n-1;i>=n/2;i--){
            if(str[i] == c){
                operations = 1;
                ans = (i + 1) + "";
                break;
            }
        }

        boolean equal = true;
        for(int i=0;i<n;i++){
            if(str[i] != c){
                equal = false;
                break;
            }
        }

        if(equal){
            System.out.println("0");
        }else{
            System.out.println(operations);
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            solve();
        }
    }
}
