import java.util.*;
import java.io.*;

public class Main {
	static int[] map = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		bfs();
	}

	static void bfs() {
		visited[1] = true;
		Queue<Node> bfsQueue = new LinkedList<>();
		bfsQueue.add(new Node(1, 0));
		while (!bfsQueue.isEmpty()) {
			Node tmp = bfsQueue.poll();
			if (tmp.x == 100) {
				System.out.println(tmp.cnt);
				return;
			}
			for (int i = 1; i <= 6; i++) {
				int nx = tmp.x + i;
				if (nx <= 100) {
					if (!visited[nx]) {
						visited[nx] = true;
						if (map[nx] != 0) {
							if (!visited[map[nx]]) {
								visited[map[nx]] = true;
								bfsQueue.add(new Node(map[nx], tmp.cnt + 1));
							}
						} else {
							bfsQueue.add(new Node(nx, tmp.cnt + 1));
						}
					}
				}
			}
		}
	}
}

class Node {
	int x;
	int cnt;

	public Node(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}
}