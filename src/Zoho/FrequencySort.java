package Zoho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 23/05/2021, Sunday, 14:28
 */
public class FrequencySort {

	public static class Element {
		Integer key;
		Integer count;

		Element(int k, int v) {
			this.key = k;
			this.count = v;
		}
	}

	static Scanner scanner = new Scanner(System.in);

	/**
	 * Method to swap..
	 * @param a
	 * @param b
	 */
	public static void swap(Element a, Element b) {
		Element temp = new Element(a.key, a.count);
		a.count = b.count;
		a.key = b.key;
		b.key = temp.key;
		b.count = temp.count;
	}

	/**
	 * Method to sort based on freq
	 * @param freqMap
	 * @return
	 */
	public static List<Element> freqSort(Map<Integer, Element> freqMap) {
		List<Element> elements = new ArrayList<>(freqMap.values());

		for (int i = 0; i < elements.size(); i++) {
			for (int j = 0; j < elements.size() && j != i; j++) {
				if (elements.get(i).count > elements.get(j).count) {
					swap(elements.get(i), elements.get(j));
				} else if (elements.get(i).count.equals(elements.get(j).count)) {
					if (elements.get(i).key < elements.get(j).key) {
						swap(elements.get(i), elements.get(j));
					}
				}
			}
		}
		return elements;
	}

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int[] arr = new int[n];

		Random random = new Random();
		Map<Integer, Element> freqMap = new HashMap<>();

		// Storing the freq count..
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
			if (freqMap.containsKey(arr[i])) {
				Element ele = freqMap.get(arr[i]);
				ele.count = ele.count + 1;
				freqMap.put(arr[i], ele);
			} else {
				Element ele = new Element(arr[i], 1);
				freqMap.put(arr[i], ele);
			}
		}

		List<Element> result = freqSort(freqMap);
		for (int i = 0; i < result.size(); i++) {
			Element ele = result.get(i);
			for(int j=0;j<ele.count;j++){
				System.out.print( ele.key + " ");
			}
		}
	}
}
