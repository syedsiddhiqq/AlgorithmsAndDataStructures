package LeetCode.medium;

import java.util.Collection;

/**
 * @author Syed Ali.
 * @createdAt 22/09/2021, Wednesday, 15:03
 */
public class BalancedString {
	private static boolean fulfilled(int[] freq) {
		boolean fulfilled = true;
		for(int f: freq) {
			if(f > 0) fulfilled = false;
		}
		return fulfilled;
	}

	private static int charToIdx(char c) {
		switch(c) {
			case 'Q': return 0;
			case 'W': return 1;
			case 'E': return 2;
		}
		return 3;
	}

	public static int balancedString(String s) {
		int N = s.length();
		int required = N/4;

		int[] freq = new int[4];
		for(int i = 0; i < N; ++i) {
			char c = s.charAt(i);
			++freq[charToIdx(c)];
		}

		// Determine the ones we need to change
		boolean equal = true;
		for(int i = 0; i < 4; ++i) {
			if(freq[i] != required) equal = false;
			freq[i] = Math.max(0, freq[i] - required);
		}

		if(equal) return 0; // Early return if all are equal

		int minLen = N;
		int start = 0;
		for(int i=0;i<N;i++){
			char ch = s.charAt(i);
			--freq[charToIdx(ch)];

			while(fulfilled(freq)){
				minLen = Math.min(minLen,i - start + 1);

				ch = s.charAt(start++);
				--freq[charToIdx(ch)];
			}
		}

		return minLen;
	}

	public static void main(String[] args) {
		System.out.println(balancedString("WWEQERQWQWWRWWERQWEQ"));
	}
}
