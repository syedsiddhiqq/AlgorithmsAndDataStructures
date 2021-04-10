//package CodeForces.contests.contest1504div2;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 10/04/2021, Saturday, 20:13
 */
public class AlmostRectangle {
	static class Fs {
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

		public long nextLong() {
			return Long.parseLong(nextString());
		}
	}

	static Fs fs = new Fs();

	static void printGrid(char[][] grid, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

	static void solve() {
		int n = fs.nextInt();
		char[][] grid = new char[n][n];
		for (int i = 0; i < n; i++) {
			grid[i] = fs.nextString().toCharArray();
		}

		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		boolean firstStart = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '*') {
					if (!firstStart) {
						x1 = i;
						y1 = j;
						firstStart = true;
					} else {
						x2 = i;
						y2 = j;
					}
					// check if in same row
					for (int k = j + 1; k < n; k++) {
						if (grid[i][k] == '*') {
							if(i+1 <n){
								grid[i + 1][j] = '*';
								grid[i + 1][k] = '*';
							}else{
								grid[i - 1][j] = '*';
								grid[i - 1][k] = '*';
							}
							printGrid(grid, n);
							return;
						}
					}

					//check if in same col
					for (int k = i + 1; k < n; k++) {
						if (grid[k][j] == '*') {
							if(j+1 < n){
								grid[i][j + 1] = '*';
								grid[k][j + 1] = '*';
							}else{
								grid[i][j-1] = '*';
								grid[k][j-1] = '*';
							}
							printGrid(grid, n);
							return;
						}
					}
				}
			}
		}

		grid[x2][y1] = '*';
		grid[x1][y2] = '*';
		printGrid(grid,n);

	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
