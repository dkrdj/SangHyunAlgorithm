import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (arr[j][i] && arr[i][k])
						arr[j][k] = true;
				}
			}
		}
		int[] cnt = new int[n + 1];
		Arrays.fill(cnt, n - 1);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] || arr[j][i])
					cnt[i]--;
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.println(cnt[i]);
		}

	}

}