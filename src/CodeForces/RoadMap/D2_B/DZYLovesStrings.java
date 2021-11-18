//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;
/**
 * @author Syed Ali.
 * @createdAt 09/04/2021, Friday, 17:12
 */
public class DZYLovesStrings {
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

	static class Letter implements Comparator<Letter>{
		int i;
		int count ;

		Letter(int i,int count){
			this.i = i;
			this.count = count;
		}

		Letter(){

		}

		@Override
		public int compare(Letter o1,Letter o2){
			if(o1.count > o2.count){
				return -1;
			}
			if(o1.count < o2.count){
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args){
		char[] str = fs.nextString().toCharArray();
		int k = fs.nextInt();
		Letter[] letters = new Letter[26];
		List<Letter> letterList = new ArrayList<>();;
		letterList.sort(new Letter());
		int[] arr = new int[27];
		for(int i=0;i<26;i++){
			int temp = fs.nextInt();
			arr[i] = temp;
			letters[i] = new Letter(i,temp);
		}
		Arrays.sort(letters,new Letter());
		int answer = 0;
		int start = 0;
		for(int i=0;i<str.length;i++){
			answer+= ++start  * arr[str[i] - 'a'];
		}

		int j = 0;
		for(int i=0;i<k;i++){
			if(arr[j] > 0){
				answer+= ++start * (arr[letters[j].i]);
				--letters[j].count;
			}else{
				j++;
			}
		}
		System.out.println(answer);
	}
}
