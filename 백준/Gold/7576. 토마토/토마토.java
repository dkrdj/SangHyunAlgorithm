import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Queue<Node> myQueue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					myQueue.add(new Node(i, j, 0));
				}
				map[i][j] = tmp;
			}
		}
		bfs(myQueue);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					ans = -1;
				}
			}
		}
		System.out.println(ans);
	}

	static void bfs(Queue<Node> myQueue) {
		Queue<Node> bfsQueue = new LinkedList<>();
		while (!myQueue.isEmpty()) {
			bfsQueue.add(myQueue.poll());
		}
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		while (!bfsQueue.isEmpty()) {
			Node tmp = bfsQueue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == 0) {

						map[nx][ny] = 1;
						bfsQueue.add(new Node(nx, ny, tmp.cnt + 1));
					}
				}
			}
			if (bfsQueue.isEmpty()) {
				ans = tmp.cnt;
			}
		}
	}
}

class Node {
	int x;
	int y;
	int cnt;

	Node(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}