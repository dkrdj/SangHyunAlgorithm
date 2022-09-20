import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			int[][] dp = new int[N + 1][N + 1];
			int[] sum = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sum[1] = arr[1];
			for (int i = 1; i < N; i++) {
				sum[i + 1] = sum[i] + arr[i + 1];
			}
			for (int i = 1; i <= N; i++)
				for (int j = 1; i + j <= N; j++) {
					dp[j][i + j] = Integer.MAX_VALUE;
					for (int div = j; div < i + j; div++) {
						dp[j][i + j] = Math.min(dp[j][i + j],
								dp[j][div] + dp[div + 1][i + j] + sum[i + j] - sum[j - 1]);
					}
				}
			System.out.println(dp[1][N]);

		}
	}

}
