import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[][] dp = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = true;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; i - j >= 0 && i + j + 1 < N; j++)
				if (arr[i - j] == arr[i + j + 1])
					dp[i - j][i + j + 1] = true;
				else
					break;

			for (int j = 1; i - j >= 0 && i + j < N; j++)
				if (arr[i - j] == arr[i + j])
					dp[i - j][i + j] = true;
				else
					break;
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(dp[S - 1][E - 1] ? 1 : 0).append("\n");
		}
		System.out.println(sb);

	}
}