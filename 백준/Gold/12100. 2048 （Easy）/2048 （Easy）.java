import java.io.*;
import java.util.*;

public class Main {
	static int N, max;

	static int[] dr = { -1, 1, 0, 0 };// 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		bfs(new Node(map, 0));
		System.out.println(max);
	}

	static void bfs(Node node) {
		Queue<Node> que = new LinkedList<>();
		que.offer(node);
		while (!que.isEmpty()) {
			Node curNode = que.poll();
			if (curNode.cnt == 5)
				return;
			for (int dir = 0; dir < 4; dir++) {
				Node nxtNode = new Node(curNode.copy(N), curNode.cnt + 1);
				boolean[][] visited = new boolean[N][N];
				boolean change = false;
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++) {
						if (dir == 0) {
							change |= gravity(nxtNode, visited, j, i, dir);
						} else if (dir == 1) {
							change |= gravity(nxtNode, visited, N - 1 - j, i, dir);
						} else if (dir == 2) {
							change |= gravity(nxtNode, visited, i, j, dir);
						} else {
							change |= gravity(nxtNode, visited, i, N - 1 - j, dir);
						}
					}
				}
				if (change)
					que.offer(nxtNode);
			}
		}
	}

	static boolean gravity(Node node, boolean[][] visited, int r, int c, int dir) {
		boolean change = false;
		int[][] map = node.map;
		if (map[r][c] == 0)
			return change;
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		while (wall(nr, nc) && map[nr][nc] == 0) {
			change = true;
			nr += dr[dir];
			nc += dc[dir];
		}
		if (wall(nr, nc) && map[r][c] == map[nr][nc] && !visited[nr][nc]) {
			change = true;
			map[nr][nc] *= 2;
			map[r][c] = 0;
			visited[nr][nc] = true;
			max = Math.max(max, map[nr][nc]);
		} else {
			nr -= dr[dir];
			nc -= dc[dir];
			if (change) {
				map[nr][nc] = map[r][c];
				map[r][c] = 0;
			}
		}
		return change;
	}

	static boolean wall(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}
}

class Node {
	int[][] map;
	int cnt;

	public Node(int[][] map, int cnt) {
		this.map = map;
		this.cnt = cnt;
	}

	public int[][] copy(int N) {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}

}