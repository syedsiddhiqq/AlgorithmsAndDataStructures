package LeetCode.medium;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 15-04-2022, Friday, 11:52
 */
public class DivideTwoIntegers {

    private static int lowerBound(int[] arr, int key){
    		int low = 0, high = arr.length - 1;
    		while(low < high){
    			int mid = (low+high)/2;
    			if(key <= arr[mid]){
    				high = mid - 1;
    			}else{
    				low = mid+1;
    			}
    		}
    		return low;
    }


    public int divide(int dividend, int divisor) {
        boolean neg = false;
        if(dividend < 0){
            neg = true;
            dividend = - 1 * dividend;
        }

        if(divisor < 0){
            neg = !neg;
            divisor = -1 * divisor;
        }

        long count = 1, sum = divisor;
        while(sum <= dividend){
            count++;
            sum += divisor;
        }

        return neg ? (int) (-1 * (count - 1)) : (int) (count - 1);
    }

    public static void main(String[] args) {

    }
}
