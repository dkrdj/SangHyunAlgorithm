import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, cnt;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++)
				map[i][j] = c[j] - '0';
		}
		visited = new boolean[N][N];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (!visited[i][j] && map[i][j] == 1) {
					dfs(i, j);
					list.add(cnt);
					cnt = 0;
				}
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for (int a : list) {
			sb.append(a).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (wall(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}

	static boolean wall(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;
		return false;
	}
}
