import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cArr1 = br.readLine().toCharArray();
		char[] cArr2 = br.readLine().toCharArray();
		int[][] LCS = new int[cArr1.length + 1][cArr2.length + 1];

		for (int i = 1; i <= cArr1.length; i++) {
			for (int j = 1; j <= cArr2.length; j++) {
				if (cArr1[i - 1] == cArr2[j - 1])
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				else
					LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);
			}
		}
		System.out.println(LCS[cArr1.length][cArr2.length]);
	}

}