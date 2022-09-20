import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		long[][] arr = new long[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			Arrays.fill(arr[i], Long.MAX_VALUE);
		for (int i = 1; i <= n; i++) {
			arr[i][i] = 0;
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = Math.min(arr[a][b], c);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (arr[j][i] != Long.MAX_VALUE && arr[i][k] != Long.MAX_VALUE) {
						arr[j][k] = Math.min(arr[j][k], arr[i][k] + arr[j][i]);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(arr[i][j] == Long.MAX_VALUE ? 0 : arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}