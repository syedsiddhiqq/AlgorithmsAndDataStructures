package codechef.rangedecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 26/03/2021, Friday, 16:03
 */
public class QueensNecklace {
	static Scanner scanner = new Scanner(System.in);

	static void solve(){
		int n = scanner.nextInt();
		int[] arr = new int[n];

		int[] freqOfFreq = new int[2001];
		int[] freq = new int[2001];
		for(int i=0;i<n;i++) {
			arr[i] = scanner.nextInt();
			++freq[arr[i]];
		}

		for(int i=1;i<2001;i++){
			freqOfFreq[freq[i]]++;
		}


		boolean flag = true;
		for(int i=1;i<2001;i++){
			if(freqOfFreq[i] > 1){
				flag = false;
				break;
			}
		}

		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}

	public static void main(String[] args) {
		int t = scanner.nextInt();
		while(t-->0){
			solve();
		}

	}
}
