package CodeForces.practice.implementation;

import java.util.*;

/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 23:50
 */
public class KthBeautifulString {
	static List<String> values = new ArrayList<>();

	/**
	 * permutation function
	 * @param str string to calculate permutation for
	 * @param l starting index
	 * @param r end index
	 */
	static  void permute(String str, int l, int r)
	{
		if (l == r){
			if(!values.contains(str)){
				values.add(str);
			}
			// System.out.println(str);
		}
		else
		{
			for (int i = l; i <= r; i++)
			{
				str = swap(str,l,i);
				permute(str, l+1, r);
				str = swap(str,l,i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	static String swap(String a, int i, int j)
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static void main(String[] args)
	{
		String str = "aaabb";
		int n = str.length();
		permute(str, 0, n-1);

		for(int i=0;i<values.size();i++){
			System.out.println(values.get(i));
		}
	}
}
