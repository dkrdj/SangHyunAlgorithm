import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int x, int y) {
		map[x][y] = false;
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		for (int i = 0; i < 4; i++) {
			if (!(x + dr[i] < 0 || x + dr[i] >= map.length || y + dc[i] < 0 || y + dc[i] >= map[0].length)
					&& map[x + dr[i]][y + dc[i]]) {
				dfs(x + dr[i], y + dc[i]);
			}
		}
	}

}