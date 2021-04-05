//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 06/04/2021, Tuesday, 03:54
 */
public class PresidentsOffice {

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

	static boolean checkIfValid(int i,int j,int n,int m){
		return i >= 0 && i < n && j >= 0 && j < m;
	}

	public static void main(String[] args){
		int n = fs.nextInt();
		int m = fs.nextInt();
		char t = fs.nextString().charAt(0);
		char[][] matrix = new char[n][m];
		for(int i=0;i<n;i++){
			matrix[i] = fs.nextString().toCharArray();
		}

		int answer = 0;
		int[] freq = new int[27];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(matrix[i][j] == t){
					// check left
					if(checkIfValid(i,j-1,n,m)){
						if(matrix[i][j-1] != t && matrix[i][j-1] != '.' && freq[matrix[i][j-1] - 'A'] != 1){
							++answer;
							freq[matrix[i][j-1] - 'A'] = 1;
						}
					}

					// check right
					if(checkIfValid(i,j+1,n,m)){
						if(matrix[i][j+1] != t && matrix[i][j+1] != '.' && freq[matrix[i][j+1] - 'A'] != 1){
							++answer;
							freq[matrix[i][j+1] - 'A'] = 1;
						}
					}

					// check up
					if(checkIfValid(i-1,j,n,m)){
						if(matrix[i-1][j] != t && matrix[i-1][j] != '.' && freq[matrix[i-1][j] - 'A'] != 1){
							++answer;
							freq[matrix[i-1][j] - 'A'] = 1;
						}
					}

					// check down
					if(checkIfValid(i+1,j,n,m)){
						if(matrix[i+1][j] != t && matrix[i+1][j] != '.' && freq[matrix[i+1][j] - 'A'] != 1){
							++answer;
							freq[matrix[i+1][j] - 'A'] = 1;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
