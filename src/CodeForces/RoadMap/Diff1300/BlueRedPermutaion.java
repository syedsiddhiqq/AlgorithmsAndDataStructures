package CodeForces.RoadMap.Diff1300;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *   Given:
 *   You are given an array of integers a of length n.
 *
 *   The elements of the array can be either different or the same.
 *
 *   Each element of the array is colored either blue or red. There are no unpainted elements i  the array.
 *
 *   No elements of some color at all are also possible.
 *
 *   2 operations:
 *
 *   1  either you can select any blue element and decrease its value by 1;
 *   2  Or you can select any red element and increase its value by 1.
 *
 *   To find:
 *
 *   whether it is possible to make 0 or more steps such that the resulting array is a permutation of numbers from 1
 *   to n?
 *
 *
 * @author Syed Ali.
 * @createdAt 17/11/2021, Wednesday, 08:02
 *
 */
public class BlueRedPermutaion {
	private static class Element implements Comparator<Element> {
		Integer value;
		Character color;

		public Element(int value, Character color) {
			this.value = value;
			this.color = color;
		}

		@Override
		public int compare(Element o1, Element o2){
			return o1.value.compareTo(o2.value);
		}

		public Element() {
		}
	}

	private static Scanner sc = new Scanner(System.in);

	private static void solve(){

		int n = sc.nextInt();
		int[] arr = new int[n];

		List<Element> blues = new ArrayList<>(),reds = new ArrayList<>();

		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		char[] colors = sc.next().toCharArray();
		for(int i=0;i<colors.length;i++){
			if(colors[i] == 'R'){
				reds.add(new Element(arr[i],'R'));
			}else{
				blues.add(new Element(arr[i],'B'));
			}
		}

		blues.sort(new Element());
		reds.sort(new Element());

		boolean possible = true;
		int index = 1;
		for(int i = 0;i<blues.size();i++,index++){
			Element element = blues.get(i);
			if(index == element.value) continue;
			if(element.value > index && element.color.equals('B')) continue;
			possible = false;
			break;
		}

		for(int i=0;i<reds.size() && possible;i++,index++){
			Element element = reds.get(i);
			if(index == element.value) continue;
			if(element.value < index && element.color.equals('R')) continue;
			possible = false;
			break;
		}

		System.out.println(possible ? "YES" : "NO");
	}

	public static void main(String[] args) {
		int t = sc.nextInt();
		while(t-->0){
			solve();
		}
	}
}
