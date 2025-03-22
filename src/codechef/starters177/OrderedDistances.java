package codechef.starters177;

import java.util.*;

public class OrderedDistances {

    private static int findOrderedDistances(int[] x, int[] y, int n, Map<Integer, Integer> pivotMap) {
        int pivotElementIndex = pivotMap.get(y[1]);
        int pivotElement = x[pivotElementIndex];
        List<int[]> nPairs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int[] temp = new int[2];
            temp[0] = Math.abs(x[i] - pivotElement);
            temp[1] = x[i];
            nPairs.add(temp);
        }

        nPairs.sort((a, b) -> {
            int diff = a[0] - b[0];
            if (diff == 0) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 1; i <= n; i++) {
            int[] nPair = nPairs.get(i - 1);
            if(nPair[1] != y[i]){
                return -1;
            }
        }
        return pivotElementIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] x = new int[n + 1];
            int[] y = new int[n + 1];
            Map<Integer, Integer> pivotMap = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                x[i] = scanner.nextInt();
                pivotMap.put(x[i], i);
            }

            for (int i = 1; i <= n; i++) {
                y[i] = scanner.nextInt();
            }
            System.out.println(findOrderedDistances(x, y,n, pivotMap));
        }
    }
}
