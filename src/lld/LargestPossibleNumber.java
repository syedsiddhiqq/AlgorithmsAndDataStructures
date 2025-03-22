package lld;

import java.util.Arrays;

public class LargestPossibleNumber {

    private static String largestPossibleNumber(Integer[] arr) {

        Arrays.sort(arr, (a, b) -> {
            Integer abCombination = Integer.parseInt(a + "" + b);
            Integer baCombination = Integer.parseInt(b + "" + a);
            return baCombination - abCombination;
        });
//        System.out.println();
        for (Integer ele : arr) {
            System.out.print(ele);
        }
        return arr.toString();
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 30, 34, 5, 9};
        largestPossibleNumber(arr);
    }
}



