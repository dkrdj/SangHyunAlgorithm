import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i + 1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 2; i < N + 1; i++)
			for (int j = 0; i + j < N + 1; j++) {
				dp[j][i + j - 1] = Integer.MAX_VALUE;
				for (int div = j; div < i + j - 1; div++)
					dp[j][i + j - 1] = Math.min(dp[j][i + j - 1],
							dp[j][div] + dp[div + 1][i + j - 1] + arr[j] * arr[div + 1] * arr[i + j]);
			}
		System.out.println(dp[0][N - 1]);

	}

}