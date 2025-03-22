package CodeForces.RoadMap.Diff1300;

import java.util.*;

/**
 * @author SyedAli
 * @createdAt 09-04-2022, Saturday, 11:06
 */
public class InversionGraphV1 {
    private static Scanner sc = new Scanner(System.in);

    private static void solve() {
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();

        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(list.isEmpty() || list.getLast()<a[i])
                list.addLast(a[i]);
            else {
                int t=list.getLast();
                while(!list.isEmpty() && list.getLast()>a[i])
                    list.removeLast();
                list.addLast(t);
            }
        }
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
