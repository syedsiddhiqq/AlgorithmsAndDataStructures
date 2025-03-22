package LeetCode.arrays;

import java.util.*;
import java.io.*;

/**
 * @author SyedAli
 * @createdAt 01-05-2023, Monday, 22:57
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while(i < nums.length){
            if(nums[i] == val && i < j){
                while(nums[j] == val) j--;
                if(nums[j] != val) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j--] = temp;
                }else return i;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums, 3);
    }
}
