import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] w = new int[N + 1];
		int[] v = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[K + 1][N + 1];

		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				int tmp = 0;
				if (w[j] <= i) {
					if (i - w[j] > 0) {
						tmp = dp[i - w[j]][j - 1] + v[j];
					} else {
						tmp = v[j];
					}
				}

				dp[i][j] = Math.max(dp[i][j - 1], tmp);
			}
		}
		System.out.println(dp[K][N]);
	}
}
