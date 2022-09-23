import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, size = 2, eat, sharkR, sharkC;
	static int[][] arr, map, dead;
	static List<Integer>[][] list;
	static int[] dr = { -1, 0, 0, 1 }, dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					arr[i][j]=10000;
					sharkR = i;
					sharkC = j;
				}
			}
		}

		int ans = 0;
		int question = bfs(sharkR, sharkC);
		while (question != -1) {
			ans += question;
			eat++;
			if (size == eat) {
				size++;
				eat = 0;
			}
			question = bfs(sharkR, sharkC);
		}
		System.out.println(ans);

	}

	static int bfs(int r, int c) {
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		PriorityQueue<Node> que = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.cost == o2.cost) {
					if (o1.r == o2.r) {
						return o1.c - o2.c;
					} else {
						return o1.r - o2.r;
					}
				} else {
					return o1.cost - o2.cost;
				}
			}
		});
		que.offer(new Node(r, c, 0));
		while (!que.isEmpty()) {
			Node curNode = que.poll();
			int fishSize = arr[curNode.r][curNode.c];
			if (fishSize != 0 && fishSize < size) {
				arr[sharkR][sharkC] = 0;
				sharkR = curNode.r;
				sharkC = curNode.c;
				arr[sharkR][sharkC] = 10000;
				return curNode.cost;
			}
			for (int i = 0; i < 4; i++) {
				int nr = curNode.r + dr[i];
				int nc = curNode.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (arr[nr][nc] <= size && !visited[nr][nc]) {
						visited[nr][nc] = true;
						que.offer(new Node(nr, nc, curNode.cost + 1));
					}
				}
			}
		}
		return -1;
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