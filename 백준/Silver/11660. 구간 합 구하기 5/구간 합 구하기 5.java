import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				arr[i][j] += arr[i][j - 1];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				arr[j][i] += arr[j - 1][i];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			int ans = arr[x2][y2];
			if (y1 > 0)
				ans -= arr[x2][y1 - 1];
			if (x1 > 0)
				ans -= arr[x1 - 1][y2];
			if (y1 > 0 && x1 > 0)
				ans += arr[x1 - 1][y1 - 1];
			sb.append(ans).append("\n");
		}
		System.out.println(sb);

	}

}
