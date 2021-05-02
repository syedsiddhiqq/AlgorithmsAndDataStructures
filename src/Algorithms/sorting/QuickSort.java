package Algorithms.sorting;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 22/04/2021, Thursday, 16:03
 */
public class QuickSort {

	static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int partition(int[] arr,int start, int end){
		int pivot = arr[end];
		int pIndex = start;
		for(int i=start;i<end;i++){
			if(arr[i]<=pivot){
				swap(arr,i,pIndex);
				pIndex++;
			}
		}
		swap(arr,end,pIndex);
		return pIndex;
	}


	static void qsort(int[] arr,int start, int end){
		if(start < end){
			int pIndex = partition(arr,start,end);
			qsort(arr,start,pIndex-1);
			qsort(arr,pIndex+1,end);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		LinkedList<Integer> l = new LinkedList<>();
		List<Integer> r = new ArrayList<>();
		r.stream().mapToInt(i->i).sum();
		qsort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
