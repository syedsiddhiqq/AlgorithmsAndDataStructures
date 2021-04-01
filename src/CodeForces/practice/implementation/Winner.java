package CodeForces.practice.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * @author Syed Ali.
 * @createdAt 01/04/2021, Thursday, 18:55
 */
public class Winner {

	static class Player{
		String name;
		int score;

		Player(String name,int score){
			this.name = name;
			this.score = score;
		}
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
		    int n = fs.nextInt();
		    Map<String ,Player> dataMap = new HashMap<>();
		    List<String> maxkeyList = new ArrayList<>();
		    int initialMaxScore = Integer.MIN_VALUE;
		    for(int i=0;i<n;i++){
		    	String s = fs.nextString();
		    	int score = fs.nextInt();
				if(dataMap.containsKey(s)){
					Player player = dataMap.get(s);
					int newScore = player.score + score;
					if(initialMaxScore < newScore){
						initialMaxScore = newScore;
						player.score = newScore;
						dataMap.put(s,player);

						if(!maxkeyList.contains(s)) maxkeyList.add(s);
					}else{
						if(initialMaxScore != newScore){
							maxkeyList.remove(s);
						}
						player.score = newScore;
						dataMap.put(s,player);
					}
				}else{
					Player player = new Player(s,score);
					if(initialMaxScore < score){
						initialMaxScore = score;
						maxkeyList.add(s);
					}
					dataMap.put(s,player);
				}
			}

			System.out.println();
		}
}
