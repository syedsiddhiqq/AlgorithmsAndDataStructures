package HackerRank.Algorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 03:34
 */
public class TwoCharactersEfficient {

	static int removeExceptTwoChars(char a, char b, char[] arr){
		int toDelete = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] != a && arr[i] !=b){
				arr[i] = '-';
				++toDelete;
			}
		}

		int count = 0;
		char[] newArr = new char[arr.length - toDelete];


		for(int i=0;i<arr.length;i++){
			if(arr[i] != '-') newArr[count++] = arr[i];
		}


		int answer = newArr.length;
		for(int i=1;i<newArr.length;i++){
			if(newArr[i] == newArr[i-1]){
				answer = 0;
			}
		}
		return answer;
	}

	static int alternate(String s) {
		int max = Integer.MIN_VALUE;
		char[] arr = s.toCharArray();
		List<Character> distinctChars = new ArrayList<>();
		int[] freq = new int[27];
		for(int i=0;i<arr.length;i++){
			int temp = arr[i] - 'a';
			if(freq[temp] == 0) distinctChars.add(arr[i]);
			freq[temp]++;
		}

		for(int i=0;i<distinctChars.size();i++){
			for(int j=i+1;j<distinctChars.size();j++){
				char[] newArr = Arrays.copyOf(arr, arr.length);
				int answer = removeExceptTwoChars(distinctChars.get(i),distinctChars.get(j),newArr);
				if(max < answer){
					max = answer;
				}
			}
		}
		return max;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		String s = bufferedReader.readLine();
		System.out.println(alternate(s));
	}
}
