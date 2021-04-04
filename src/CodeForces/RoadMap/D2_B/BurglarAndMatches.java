package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 05/04/2021, Monday, 00:16
 */
public class BurglarAndMatches {
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

	static class MatchBox implements Comparator<MatchBox> {
		int n;
		int matches;

		MatchBox(int n, int matches) {
			this.n = n;
			this.matches = matches;
		}

		MatchBox() {

		}

		@Override
		public int compare(MatchBox o1, MatchBox o2) {
			if (o1.matches < o2.matches) {
				return -1;
			}
			if (o1.matches > o2.matches) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		int n = fs.nextInt();
		int m = fs.nextInt();
		List<MatchBox> matchBoxes = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int match = fs.nextInt();
			int matches = fs.nextInt();
			matchBoxes.add(new MatchBox(match, matches));
		}
		matchBoxes.sort(new MatchBox());
		int matches = 0;
		for (int i = 0; i < matchBoxes.size() && n > 0; i++) {
			MatchBox matchBox = matchBoxes.get(i);
			if(n >= matchBoxes.get(i).n){
				matches+= matchBox.n * matchBox.matches;
				n-=matchBox.n;
			}else{
				matches+=n*matchBox.matches;
				n = 0;
			}
		}
		System.out.println(matches);
	}
}
