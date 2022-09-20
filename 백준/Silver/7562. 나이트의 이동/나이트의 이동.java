import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] visited;
	static int l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			l = Integer.parseInt(br.readLine());
			visited = new boolean[l][l];
			st = new StringTokenizer(br.readLine());
			int stX = Integer.parseInt(st.nextToken());
			int stY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			bfs(stX, stY, endX, endY);
		}

	}

	static void bfs(int stX, int stY, int endX, int endY) {
		if (stX == endX && stY == endY) {
			System.out.println("0");
			return;
		}
		visited[stX][stY] = true;
		Queue<Node> bfsQueue = new LinkedList<>();
		bfsQueue.add(new Node(stX, stY, 0));
		while (!bfsQueue.isEmpty()) {
			Node tmp = bfsQueue.poll();
			int[] dx = { 2, 2, 1, 1, -1, -1, -2, -2 };
			int[] dy = { 1, -1, 2, -2, 2, -2, 1, -1 };
			for (int i = 0; i < 8; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx == endX && ny == endY) {
					System.out.println(tmp.cnt + 1);
					return;
				} else if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						bfsQueue.add(new Node(nx, ny, tmp.cnt + 1));
					}
				}
			}
		}
	}
}

class Node {
	int x;
	int y;
	int cnt;

	public Node(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}