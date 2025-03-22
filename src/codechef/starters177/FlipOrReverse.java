package codechef.starters177;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipOrReverse {

    private static void makeEqual(char[] a, char[] b, int n) {
        List<int[]> ranges = new ArrayList<>();
        int l = 0, r = n - 1, k = 0;
        while (true) {
            int[] arr = checkIfEqual(a, b, l, r);
            l = arr[0];
            r = arr[1];
            if (l > r) break;
            k++;
            ranges.add(new int[]{l, r});
            flip(a, b, l, r);
        }
        System.out.println(ranges.size());
        for(int i=0;i<ranges.size();i++){
            int[] arr = ranges.get(i);
            System.out.println(1 + " " + (arr[0] + 1) + " " + ( arr[1] + 1));
        }
    }

    private static void flip(char[] a, char[] b, int l, int r){
        while(l <= r){
            if(l == r){
                a[l] = a[l] == '1' ? '0' : '1';
            }else{
                a[l] = a[l] == '1' ? '0'  : '1';
                a[r] = a[r] == '1' ? '0'  : '1';
            }
            l++;
            r--;
        }
    }

    private static int[] checkIfEqual(char[] a, char[] b, int l, int r) {
        while (l <= r) {
            if(a[l] == b[l] && a[r] == b[r]){
                l++;
                r--;
            }else  if (a[l] == b[l]) {
                l++;
            }else  if(a[r] == b[r]){
                r--;
            }else if(a[l] != b[l] && a[r] != b[r]){
                break;
            }
        }
        return new int[]{l, r};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String a = br.readLine().trim();
            String b = br.readLine().trim();
            makeEqual(a.toCharArray(), b.toCharArray(), n);
        }
    }
}
