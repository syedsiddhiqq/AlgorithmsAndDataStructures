package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 17/04/2021, Saturday, 16:47
 */
public class PrefixFlipEasyVersion {
	static class Fs{
			private BufferedReader reader;
			private StringTokenizer stt;

			public Fs() {
				reader = new BufferedReader(new InputStreamReader(System.in));
			}

			public String nextLine() {
				try {
					return reader.readLine();
				} catch (IOException e) {
					return null;
				}
			}

			public String nextString() {
				while (stt == null || !stt.hasMoreTokens()) {
					stt = new StringTokenizer(nextLine());
				}
				return stt.nextToken();
			}

			public int nextInt() {
				return Integer.parseInt(nextString());
			}

			public long nextLong(){ return Long.parseLong(nextString()); }
		}

		static Fs fs = new Fs();

		static void swap(char[] str,int i, int j){
			char temp = (str[i] == '0') ? '1' : '0';
			str[i] = (str[j] == '0') ? '1' : '0';
			str[j] = temp;
		}

		static void reverseAndInvert(char[] str,int start, int end){
			for(int i=start,j = end;i<=j;i++,j--){
				swap(str, i,j);
			}
		}

		static void solve(){
		 	int n = fs.nextInt();
		 	char[] a = fs.nextString().toCharArray();
		 	char[] b = fs.nextString().toCharArray();
		 	List<Integer> prefixLengths = new ArrayList<>();
			int moves = 0;
		 	for(int i=n-1;i>=0;i--){
		 		if(a[i] != b[i]){
		 			if(a[0] != a[i]){
		 				a[0] = a[i];
						prefixLengths.add(1);
		 				++moves;
					}
					++moves;
		 			reverseAndInvert(a,0,i);
					prefixLengths.add(i+1);
				}
			}
			System.out.print(moves + " ");
		 	for(int i=0;i<prefixLengths.size();i++){
				System.out.print(prefixLengths.get(i) + " ");
			}
			System.out.println();
		}

		public static void main(String[] args){
		    int t = fs.nextInt();
		    while(t-->0){
		        solve();
		    }
		}
}
