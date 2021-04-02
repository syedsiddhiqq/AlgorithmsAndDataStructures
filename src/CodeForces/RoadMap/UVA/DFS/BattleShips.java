package CodeForces.RoadMap.UVA.DFS;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 02/04/2021, Friday, 15:45
 */
public class BattleShips {

	static void dfs(int i, int j,int n,char[][] g) {
		if(i >= n || j >= n || i < 0 || j < 0)
			return;
		if(g[i][j] == '.')  return;
		g[i][j] = '.';
		dfs(i+1, j,n,g);
		dfs(i-1, j,n,g);
		dfs(i, j+1,n,g);
		dfs(i, j-1,n,g);
	}

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

		public static void main(String[] args){
		    int t = fs.nextInt();
		    for(int k=1;k<=t;k++){
				int n = fs.nextInt();
				int answer = 0;
				char[][] grid = new char[n][n];
				for(int i=0;i<n;i++){
					grid[i] = fs.nextString().toCharArray();
				}

				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						if(grid[i][j] == 'x'){
							answer++;
							dfs(i,j,n,grid);
						}
					}
				}
				System.out.println("Case "+k+": "+answer);
			}
		}
}
