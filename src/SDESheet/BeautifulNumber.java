package SDESheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Syed Ali.
 * @createdAt 29/01/2022, Saturday, 08:24
 */
public class BeautifulNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		long[] preProcessArray = preProcess();
		for(int t_i = 0; t_i < T; t_i++)
		{
			String[] str = br.readLine().split(" ");
			int l = Integer.parseInt(str[0]);
			int r = Integer.parseInt(str[1]);
			wr.write(preProcessArray[r]-preProcessArray[l-1]+"\n");

		}

		wr.close();
		br.close();
	}

	static boolean check(int u) {
		int cnt = 40;
		while (cnt > 0 && u!=4) {
			int ans = 0;
			while (u > 0) {
				ans += (u%10)*(u%10);
				u /= 10;
			}
			u = ans;
			cnt--;
			if (u==1) {return true;}
		}
		return false;
	}

	static long[] preProcess() {
		long[] preProcessArray = new long[1000005];
		for (int i=1;i<=1000000;i++) {
			if (check(i)) {
				preProcessArray[i] = i;
			}
		}

		for (int i=1;i<=1000000;i++) {
			preProcessArray[i] += preProcessArray[i-1];
		}
		return preProcessArray;
	}
}
