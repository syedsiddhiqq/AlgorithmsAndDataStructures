//package CodeForces.RoadMap.D2_B;

import java.util.*;
import java.io.*;

/**
 * @author Syed Ali.
 * @createdAt 06/04/2021, Tuesday, 22:42
 */
public class KeyBoard {
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

	static boolean euclideanDistance(int x1, int y1, int x2, int y2, int x) {
		return Math.sqrt(Math.pow(x2 - x1, 2) +
				Math.pow(y2 - y1, 2) * 1.0) <= x;
	}

	static class Coordinate {
		int x;
		int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Coordinate() {

		}

		public int getX() {
			return x;
		}
	}

	public static void main(String[] args) {
		int n, m, x;
		n = fs.nextInt();
		m = fs.nextInt();
		x = fs.nextInt();

		Map<Character, List<Coordinate>> data = new HashMap<>();
		StringBuilder[] row = new StringBuilder[n];
		for (int i = 0; i < n; i++) {
			row[i] = new StringBuilder().append(fs.nextString());
			for (int j = 0; j < row[i].length(); j++) {
				char ch = row[i].charAt(j);
				if (!data.containsKey(ch)) {
					List<Coordinate> coordinates = new ArrayList<>();
					coordinates.add(new Coordinate(i, j));
					data.put(ch, coordinates);
				} else {
					data.get(ch).add(new Coordinate(i, j));
				}
			}
		}

		int q = fs.nextInt();
		String text = fs.nextString();
		String lowerCaseVer = text.toLowerCase();
		boolean impossible = false;
		int answer = 0;

		int[] upperCase = new int[27];
		for (int i = 0; i < q; i++) {
			char ch = text.charAt(i);
			ch = ch < 96 ? lowerCaseVer.charAt(i) : ch;
			if (data.containsKey(ch)) {
				Coordinate coordinatesOffCh = data.get(ch).stream().findAny().get();
				if (text.charAt(i) < 96 && !data.containsKey('S')) {
					impossible = true;
					break;
				} else if (text.charAt(i) < 96 && upperCase[text.charAt(i) - 'A'] == 0) {
					List<Coordinate> ofShift = data.get('S');
					boolean possibleValueFound = false;
					if (ofShift.stream().anyMatch(coordinate -> euclideanDistance(coordinatesOffCh.x, coordinatesOffCh.y, coordinate.x,
							coordinate.y, x))) {
						possibleValueFound = true;
						upperCase[text.charAt(i) - 'A'] = 1;
					}
					if(!possibleValueFound) ++answer;
				}
			} else {
				impossible = true;
				break;
			}
		}
		System.out.println(impossible ? "-1" : answer);
	}
}