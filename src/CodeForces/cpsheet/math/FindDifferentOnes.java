package CodeForces.cpsheet.math;

import java.util.*;

public class FindDifferentOnes {
    private static void findDifferentOnes(int n, int[] arr, List<int[]> queries) {
        Stack<int[]> st = new Stack<>();
        Map<Integer, Integer> rangeMap = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty()) {
                int[] topElement = st.peek();
                if (topElement[0] == arr[i]) {
                    st.pop();
                } else {
                    rangeMap.put(i, topElement[1]);
                    break;
                }
            }
            st.push(new int[]{arr[i], i});
        }

        for (int[] query : queries) {
            int l = query[0] - 1, r = query[1] - 1;
            if(!rangeMap.containsKey(l)){
                System.out.println("-1  -1");
            }else{
                int nextDifferentElementIndex = rangeMap.get(l);
                if(nextDifferentElementIndex > r){
                    System.out.println("-1  -1");
                }else{
                    System.out.println((l + 1) + " " + (nextDifferentElementIndex + 1));
                }
            }
        }
        System.out.println();
    }

    private static void findDifferentOnesV1(int n, int[] arr, List<int[]> queries) {
        int[] next = new int[n];
        next[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            if(arr[i] == arr[i + 1]){
                next[i] = next[i + 1];
            }else{
                next[i] = i + 1;
            }
        }

        for (int[] query : queries) {
            int l = query[0] - 1, r = query[1] - 1;
            int nextDifferentElementIndex = next[l];
            if(nextDifferentElementIndex > r){
                System.out.println("-1  -1");
            }else{
                System.out.println((l + 1) + " " + (nextDifferentElementIndex + 1));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int q = sc.nextInt();
            List<int[]> queries = new ArrayList<>();
            for(int i=0;i<q;i++){
                int[] query = new int[2];
                query[0] = sc.nextInt();
                query[1] = sc.nextInt();
                queries.add(query);
            }
            findDifferentOnes(n, arr, queries);
        }
    }
}
