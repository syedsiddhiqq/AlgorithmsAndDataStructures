//package CodeForces.RoadMap.D2_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Syed Ali.
 * @createdAt 05/04/2021, Monday, 01:43
 */
public class Coins {
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

	public static void main(String[] args) {
		String[] strings = new String[3];
		int agtb = 0;
		int agtc = 0;
		int bgtc = 0;

		boolean impossible = false;
		for (int i = 0; i < 3; i++) {
			strings[i] = fs.nextString();

			if ((strings[i].charAt(0) == 'A')) {
				if (strings[i].charAt(2) == 'B') {
					if (strings[i].charAt(1) == '>') {
						if (agtb == 2) {
							impossible = true;
						}
						agtb = 1;
					}else{
						agtb = 2;
					}
				} else {
					if (strings[i].charAt(1) == '>') {
						if (agtc == 2) {
							impossible = true;
						}
						agtc = 1;
					}else{
						agtc = 2;
					}
				}
			}

			if ((strings[i].charAt(0) == 'B')) {
				if (strings[i].charAt(2) == 'A') {
					if (strings[i].charAt(1) == '>') {
						if (agtb == 1) {
							impossible = true;
						}
						agtb = 2;
					}else {
						agtb = 1;
					}
				} else {
					if (strings[i].charAt(1) == '>') {
						if (bgtc == 2) {
							impossible = true;
						}
						bgtc = 1;
					}else{
						bgtc = 2;
					}
				}
			}

			if ((strings[i].charAt(0) == 'C')) {
				if (strings[i].charAt(2) == 'A') {
					if (strings[i].charAt(1) == '>') {
						if (agtc == 1) {
							impossible = true;
						}
						agtc = 2;
					}else{
						agtc = 1;
					}
				} else {
					if (strings[i].charAt(1) == '>') {
						if (bgtc == 1) {
							impossible = true;
						}
						bgtc = 2;
					}else{
						bgtc = 1;
					}
				}
			}
		}

		if(agtb == 1 && agtc == 2 && bgtc == 1){
			impossible = true;
		}else if(agtc == 1 && agtb == 2 && bgtc == 2){
			impossible = true;
		}

		if (!impossible) {
			StringBuilder result = new StringBuilder();
			if (agtb == 1 && agtc == 1) {
				if (bgtc == 1) {
					result.append("CB");
				} else {
					result.append("BC");
				}
				result.append("A");
			} else if (bgtc == 1) {
				if (agtc == 1) {
					result.append("CA");
				} else {
					result.append("AC");
				}
				result.append("B");
			} else {
				if (agtb == 1) {
					result.append("BA");
				} else {
					result.append("AB");
				}
				result.append("C");
			}
			System.out.println(result);
		} else {
			System.out.println("Impossible");
		}
	}
}
