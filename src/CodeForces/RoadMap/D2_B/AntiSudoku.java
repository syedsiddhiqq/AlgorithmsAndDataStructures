//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 15/04/2021, Thursday, 23:56
 */
public class AntiSudoku {
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

		static void solve(){
		 	String[] sudoku = new String[9];
		 	for(int i=0;i<9;i++){
		 		sudoku[i] = fs.nextString();
			}

		 	for(int i=0;i<9;i++){
		 		sudoku[i] = sudoku[i].replace("1","5");
			}

		 	for(int i=0;i<9;i++){
				System.out.println(sudoku[i]);
			}
		}

		public static void main(String[] args){
		    int t = fs.nextInt();
		    while(t-->0){
		        solve();
		    }
		}
}
