package CodeForces.RoadMap.Diff1300;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 26-04-2022, Tuesday, 20:57
 */
public class IncreasingSubsequence {
    private static Scanner s = new Scanner(System.in);

    private static void solve() {
        int n = s.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> temp = new ArrayList<>();

        if (list.peekFirst() < list.peekLast()) {
            temp.add(list.pollFirst());
            sb.append("L");
        }else{
            temp.add(list.pollLast());
            sb.append("R");
        }

        while (!list.isEmpty()) {
            int lastElement = temp.get(temp.size() - 1);
            if (list.peekFirst() > lastElement && list.peekLast() > lastElement) {
                if (list.peekFirst() < list.peekLast()) {
                    temp.add(list.pollFirst());
                    sb.append("L");
                }else{
                    temp.add(list.pollLast());
                    sb.append("R");
                }
            }else if(list.peekFirst() > lastElement){
                temp.add(list.pollFirst());
                sb.append("L");
            }else if(list.peekLast() > lastElement){
                temp.add(list.pollLast());
                sb.append("R");
            }else{
                break;
            }
        }

        System.out.println(sb.length());
        System.out.println(sb);
    }

    public static void main(String[] args) {
        solve();
        s.close();
    }
}
