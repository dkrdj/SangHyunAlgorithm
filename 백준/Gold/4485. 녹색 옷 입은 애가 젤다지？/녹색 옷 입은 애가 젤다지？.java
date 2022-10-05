import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };// 상 우 하 좌(시계방향)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		N = Integer.parseInt(br.readLine());
		while (N != 0) {
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dijkstra();
			sb.append("Problem ").append(cnt++).append(": ").append(ans).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);

	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
		int[][] dist = new int[N][N];
		for (int[] a : dist) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}
		pq.offer(new Node(0, 0, map[0][0]));
		dist[0][0] = map[0][0];
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			if (curNode.r == N - 1 && curNode.c == N - 1) {
				ans = curNode.cost;
				return;
			}
			if (curNode.cost > dist[curNode.r][curNode.c]) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nr = curNode.r + dr[i];
				int nc = curNode.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N)
					if (dist[nr][nc] > map[nr][nc] + curNode.cost) {
						dist[nr][nc] = map[nr][nc] + curNode.cost;
						pq.offer(new Node(nr, nc, dist[nr][nc]));
					}
			}
		}
	}

}

class Node {
	int r;
	int c;
	int cost;

	public Node(int r, int c, int cost) {
		this.r = r;
		this.c = c;
		this.cost = cost;
	}

}