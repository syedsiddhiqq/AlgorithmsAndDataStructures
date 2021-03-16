package HackerRank;

import java.io.*;
import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 15/03/2021, Monday, 14:58
 */
public class QHEAP {

	static void heapify(List<Integer> arr, int i, int n){
		int largest = i;
		int leftChild = i * 2 + 1;
		int rightChild = i * 2 + 2;

		if(leftChild < n && arr.get(leftChild) < arr.get(largest)){
			largest = leftChild;
		}

		if(rightChild < n && arr.get(rightChild) < arr.get(largest)){
			largest = rightChild;
		}

		if(largest != i){
			int temp = arr.get(largest);
			arr.set(largest,arr.get(i));
			arr.set(i,temp);
			heapify(arr,largest,n);
		}
	}

	static void heapSort(List<Integer> arr){
		int n = arr.size();
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,i,n);
		}
	}

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-->0){
			int query = scanner.nextInt();
			if(query == 1){
				int elementToAdd = scanner.nextInt();
				arr.add(elementToAdd);
				heapSort(arr);
			}else if(query == 2){
				Integer elementToDel = scanner.nextInt();
				int indexOfElementToBeRemoved = arr.indexOf(elementToDel);
				arr.set(indexOfElementToBeRemoved,arr.get(arr.size()-1));
				arr.remove(arr.size()-1);
				heapify(arr,indexOfElementToBeRemoved,arr.size());
			}else{
				System.out.println(arr.get(0));
			}
		}
	}
}
