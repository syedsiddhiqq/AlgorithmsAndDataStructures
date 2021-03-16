package GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Syed Ali.
 * @createdAt 12/03/2021, Friday, 00:08
 */
public class AnagramCheckGFG {
	public static void main (String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String str = br.readLine();
			String s1 = str.split(" ")[0];
			String s2 = str.split(" ")[1];

			AnagramSolution obj = new AnagramSolution();

			if(obj.isAnagram(s1,s2))
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}



		}

	}
}

class AnagramSolution{
	public boolean isAnagram(String a,String b){
		if(a.length() == b.length()){
			char[] strA = a.toCharArray();
			char[] strB = b.toCharArray();

			int[] freqA = new int[a.length()];
			int[] freqB = new int[a.length()];

			for(int i=0;i<a.length();i++){
				freqA[strA[i] - 'a']++;
				freqB[strB[i] - 'a']++;
			}

			for(int i=0;i<a.length();i++){
				if(freqA[i] != freqB[i]){
					return false;
				}
			}
			return true;
 		}
		return false;
	}
}
