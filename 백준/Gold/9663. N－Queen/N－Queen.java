import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();
	static int N;
	static int ans = 0;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int r, int cnt) {
		if (cnt == N) {
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[r][i]) {
				int tmp = move(r, i);
				dfs(r + 1, cnt + 1);
				for (int j = 0; j < tmp; j++) {
					visited[stack1.pop()][stack2.pop()] = false;
				}
			}
		}
	}

	static boolean wall(int r, int c) {
		if (r >= N || r < 0 || c >= N || c < 0)
			return false;
		return true;
	}

	static int move(int r, int c) {
		int cnt = 0;
		for (int i = r + 1; i < N; i++) {
			if (!visited[i][c]) {
				visited[i][c] = true;
				stack1.add(i);
				stack2.add(c);
				cnt++;
			}
		}
		int nr = r;
		int nc = c;
		while (wall(nr, nc)) {
			if (!visited[nr][nc]) {
				visited[nr][nc] = true;
				stack1.add(nr);
				stack2.add(nc);
				cnt++;
			}
			nr++;
			nc++;
		}
		nr = r;
		nc = c;
		while (wall(nr, nc)) {
			if (!visited[nr][nc]) {
				visited[nr][nc] = true;
				stack1.add(nr);
				stack2.add(nc);
				cnt++;
			}
			nr++;
			nc--;
		}
		return cnt;
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

}