package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 07/04/2021, Wednesday, 11:58
 */
public class TicTocToe1 {
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

	static boolean bfs(char[][] grid, char ch){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				// left
				if(j-1 >=0 && j-2 >=0 && grid[i][j] == ch && grid[i][j-1] == ch && grid[i][j-2] == ch){
					return true;
				}
				// right
				if(j+1 <3 && j+2 <3 && grid[i][j] == ch && grid[i][j+1] == ch && grid[i][j+2] == ch){
					return true;
				}

				// up
				if(i-1 >=0 && i-2>=0 && grid[i][j] == ch && grid[i-1][j] == ch && grid[i-2][j] == ch){
					return true;
				}

				// down
				if(i+1 <3 && i+2<3 && grid[i][j] == ch && grid[i+1][j] == ch && grid[i+2][j] == ch){
					return true;
				}
			}
		}
		return false;
	}

	static void solve(){
		char[][] grid = new char[3][3];
		int countOfX = 0,countOfY = 0;
		for(int i=0;i<3;i++){
			grid[i] = fs.nextString().toCharArray();
			for(int j=0;j<3;j++){
				if(grid[i][j] == 'X') ++countOfX;
				else if(grid[i][j] == 'O') ++countOfY;
			}
		}

		if(countOfX > countOfY){
			// Either x has won -- valid
			// Y could have won -- invalid

			if(Math.abs(countOfX - countOfY) == 1){
				if(bfs(grid,'O')){
					System.out.println("no");
					return;
				}
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}else if(countOfY > countOfX){
			System.out.println("no");
		}else {
			if (bfs(grid,'X')){
				System.out.println("no");
			}System.out.println("yes");
		}
	}

	public static void main(String[] args){
		int t = fs.nextInt();
		while(t-->0){
			solve();
		}
	}
}
