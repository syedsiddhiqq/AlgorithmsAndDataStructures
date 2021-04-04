//package CodeForces.RoadMap.D2_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author Syed Ali.
 * @createdAt 04/04/2021, Sunday, 15:53
 */
public class PanScales {
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
		String[] s = fs.nextString().split("\\|");
		String leftWeights = s.length > 0 ? s[0] : "";
		String rightWeights = s.length > 1 ? s[1] : "";
		String inputWeights = fs.nextString();
		boolean minLeft = leftWeights.length() < rightWeights.length();
		int reqWeight;
		boolean impossible = false;
		if(minLeft){
			reqWeight = rightWeights.length() - leftWeights.length();
			if(inputWeights.length() >= reqWeight){
				leftWeights+=inputWeights.substring(0,reqWeight);
				inputWeights = inputWeights.substring(reqWeight);
			}else{
				impossible = true;
			}
		}else{
			reqWeight = leftWeights.length() - rightWeights.length();
			if(inputWeights.length() >= reqWeight){
				rightWeights+=inputWeights.substring(0,reqWeight);
				inputWeights = inputWeights.substring(reqWeight);
			}else{
				impossible = true;
			}
		}
		StringBuilder result =  new StringBuilder();
		if(!impossible && inputWeights.length() % 2 == 0){
			result.append(leftWeights);
			result.append(inputWeights, 0, inputWeights.length()/2);
			result.append("|");
			result.append(rightWeights);
			result.append(inputWeights.substring(inputWeights.length()/2));
			System.out.println(result);
		}else{
			System.out.println("Impossible");
		}
	}
}
