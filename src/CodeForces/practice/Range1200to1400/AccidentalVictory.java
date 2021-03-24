package CodeForces.practice.Range1200to1400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 23/03/2021, Tuesday, 01:41
 */
public class AccidentalVictory {
	static class Fs{
		private BufferedReader bufferedReader;
		private StringTokenizer stt;


		public Fs(){
			this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String nextLine() {
			try{
				return bufferedReader.readLine();
			}catch (IOException e){
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

		public long nextLong() { return Long.parseLong(nextString());}
	}

	static Fs fs = new Fs();

	static class Cell{
		int data;
		int index;

		Cell(int data,int index){
			this.data = data;
			this.index = index;
		}
	}

	static void solve(){
		int n = fs.nextInt();
		List<Cell> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			int temp = fs.nextInt();
			arr.add(new Cell(temp,i+1));
		}

		Comparator comparator = (Comparator<Cell>) (o1, o2) -> {
			if(o1.data > o2.data) return 1;
			else return 0;
		};

		arr.sort(comparator);



	}

	public static void main(String[] args) {

		int t = fs.nextInt();
		while(t-- > 0){
			solve();
		}
	}
}
