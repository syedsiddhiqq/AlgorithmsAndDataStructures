package HackerRank.Algorithms.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Syed Ali.
 * @createdAt 27/03/2021, Saturday, 12:02
 */
public class WeightedUniformStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		String s = bufferedReader.readLine();
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = scanner.nextInt();
		weightedUniformStrings(s,arr);
	}

	// Complete the weightedUniformStrings function below.
	static String[] weightedUniformStrings(String s, int[] queries) {
		String[] result = new String[queries.length];
		char[] str = s.toCharArray();
		int[] weight = new int[100000000];
		char prev = '-';
		int mul = 1;
		for(int i=0;i<str.length;i++){
			int ascii = str[i] - 'a' + 1;
			if(ascii == prev){
				++mul;
				ascii = ascii * mul;
			}else{
				mul = 1;
			}
			prev = str[i];
			weight[ascii] = 1;
		}

		for(int i=0;i<queries.length;i++){
			if(weight[queries[i]] == 1){
				result[i] = "Yes";
			}else{
				result[i] = "No";
			}
		}
		return result;
	}
}
