//package GFG;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
///**
// * @author Syed Ali.
// * @createdAt 12/03/2021, Friday, 00:27
// */
//public class RemoveDuplicates {
//	public static void main(String args[]) throws IOException {
//		BufferedReader read =
//				new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(read.readLine());
//		while (t-- > 0) {
//			String s = read.readLine();
//
//			Solution ob = new Solution();
//			String result = ob.removeDups(s);
//
//			System.out.println(result);
//		}
//	}
//}
//
//class RemoveDupsSolution{
//	String removeDups(String S) {
//		char[] strArr =  S.toCharArray();
//		StringBuilder result = new StringBuilder();
//		int[] freq = new int[27];
//
//		for(int i=0;i<S.length();i++){
//			freq[strArr[i] - 'a']++;
//		}
//
//		for(int i=0;i<S.length();i++){
//			char temp = strArr[i];
//			if(freq[temp - 'a'] >= 1) {
//				result.append(temp);
//				freq[temp - 'a'] = -1;
//			}
//		}
//		return result.toString();
//	}
//}
