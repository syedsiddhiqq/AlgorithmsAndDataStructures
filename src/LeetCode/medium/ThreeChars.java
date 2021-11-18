package LeetCode.medium;

/**
 * @author Syed Ali.
 * @createdAt 26/09/2021, Sunday, 10:38
 */
public class ThreeChars {
	public static int numberOfSubstrings(String s) {
		int count[] = {0, 0, 0}, res = 0 , i = 0, n = s.length();
		for (int j = 0; j < n; ++j) {
			++count[s.charAt(j) - 'a'];
			while (count[0] > 0 && count[1] > 0 && count[2] > 0)
				--count[s.charAt(i++) - 'a'];
			res += i;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(numberOfSubstrings("abcabc"));
	}
}
