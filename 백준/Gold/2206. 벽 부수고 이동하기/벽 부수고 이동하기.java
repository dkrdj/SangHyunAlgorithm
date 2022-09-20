import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	static boolean[][] visited;
	static boolean[][] brokeVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		brokeVisited = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j + 1] = (str.charAt(j)-'0' == 1 ? false : true);
			}
		}
		bfs(N, M);
	}

	static void bfs(int N, int M) {
		visited[1][1] = true;
		Queue<Node> bfsQueue = new LinkedList<>();
		bfsQueue.add(new Node(1, 1, false, 1));
		while (!bfsQueue.isEmpty()) {
			Node tmp = bfsQueue.poll();
			if (tmp.x == N && tmp.y == M) {
				System.out.println(tmp.cnt);
				return;
			}
			int[] dx = { 1, -1, 0, 0 };
			int[] dy = { 0, 0, 1, -1 };
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx <= N && nx > 0 && ny <= M && ny > 0) {
					if (tmp.broke) {
						if (map[nx][ny] && !visited[nx][ny] && !brokeVisited[nx][ny]) {
							brokeVisited[nx][ny] = true;
							bfsQueue.add(new Node(nx, ny, true, tmp.cnt + 1));
						}
					} else {
						if (!visited[nx][ny]) {
							visited[nx][ny] = true;
							if (map[nx][ny]) {
								bfsQueue.add(new Node(nx, ny, false, tmp.cnt + 1));
							} else {
								bfsQueue.add(new Node(nx, ny, true, tmp.cnt + 1));
							}
						}
					}
				}
			}
			if(bfsQueue.isEmpty()) {
				System.out.println("-1");
			}
		}
	}
}

class Node {
	int x;
	int y;
	boolean broke;
	int cnt;

	public Node(int x, int y, boolean broke, int cnt) {
		this.x = x;
		this.y = y;
		this.broke = broke;
		this.cnt = cnt;
	}
}