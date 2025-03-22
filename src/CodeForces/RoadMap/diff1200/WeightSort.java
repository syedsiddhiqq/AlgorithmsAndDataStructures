package CodeForces.RoadMap.diff1200;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 20-03-2022, Sunday, 11:26
 */
public class WeightSort {
    private static Scanner s = new Scanner(System.in);

    private static void weightSort(){
        int n = s.nextInt(),m = s.nextInt();

        Integer[] arr = new Integer[n+1];
        List<Integer> swaps = new ArrayList<>();

        Map<Integer, Queue<Integer>> indices = new HashMap<>();
        for(int i=1;i<=n;i++){
            arr[i] = s.nextInt();
            if(indices.containsKey(arr[i])){
                indices.get(arr[i]).offer(i);
            }else{
                Queue<Integer> q = new PriorityQueue<>();
                q.offer(i);
                indices.put(arr[i],q);
            }
        }

        for(int i=0;i<m;i++)
            swaps.add(s.nextInt());

        Arrays.sort(arr,1,n+1);
        for(int i=1;i<=n;i++){
            Queue<Integer> q = indices.get(arr[i]);
            if(!q.isEmpty()){
              int index = q.poll();
              if(index > i){
                  for(int j = i;j<index;j++){
                      if(!swaps.contains(j)){
                          System.out.println("NO");
                          return;
                      }
                  }
              }else if(index < i){
                  for(int j = index;j<i;j++){
                      if(!swaps.contains(j)){
                          System.out.println("NO");
                          return;
                      }
                  }
              }
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while(t-->0){
            weightSort();
        }
    }
}
