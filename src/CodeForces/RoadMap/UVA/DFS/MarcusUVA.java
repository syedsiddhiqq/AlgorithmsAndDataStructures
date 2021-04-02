//package CodeForces.RoadMap.UVA.DFS;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 02/04/2021, Friday, 13:39
 */
public class MarcusUVA {

	static String s = "@IEHOVA#";

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

	static void dfs(char[][] grid, int i, int j, int row, int col, int l, int[] directions) {
		if (i < 0 || i >= row || j < 0 || j >= col) {
			return;
		}

		if(grid[i][j] != s.charAt(l)){
			return;
		}

		if (grid[i][j] == '#') {
			for (int x = 0; x < l; x++) {
				if(x > 0){
					System.out.print(" ");
				}
				if (directions[x] == 0) {
					System.out.print("left");
				} else if (directions[x] == 1) {
					System.out.print("right");
				} else {
					System.out.print("forth");
				}
				System.out.println();
			}
			return;
		}
		// up
		directions[l] = 2;
		dfs(grid, i - 1, j, row, col, l + 1, directions);

		// left
		directions[l] = 0;
		dfs(grid, i, j - 1, row, col, l + 1, directions);

		// right
		directions[l] = 1;
		dfs(grid, i, j + 1, row, col, l + 1, directions);
	}

	static void solve() {
		int row, col;
		row = fs.nextInt();
		col = fs.nextInt();
		int[] directions = new int[row * col];
		char[][] grid = new char[row][col];
		for (int i = 0; i < row; i++) {
			grid[i] = fs.nextString().toCharArray();
		}

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (grid[i][j] == '@') {
					dfs(grid, i, j, row, col, 0, directions);
				}
	}

	public static void main(String[] args) {
		int t = fs.nextInt();
		while (t-- > 0) {
			solve();
		}
	}
}
