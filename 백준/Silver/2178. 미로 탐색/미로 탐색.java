import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M + 1]; // 미로 정이
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		System.out.println(bfs(map, N, M));
	}

	static int bfs(int[][] map, int N, int M) {
		boolean[][] visited = new boolean[N + 1][M + 1]; // 방문여부배열정의
		visited[1][1] = true; // 탐색을 시작할 정점
		Queue<Node> myQueue = new LinkedList<>(); // 큐에 x,y,cnt를 위해 node생성
		Node[][] node = new Node[N + 1][M + 1]; // 큐에 들어갈 노드 정의
		node[1][1] = new Node(1, 1, 1); // 생성자
		myQueue.add(node[1][1]); // 큐에 넣어줌
		end :while (!myQueue.isEmpty()) {
			Node tmp = myQueue.poll(); // 꺼낸 노드의 cnt를 나중에 씀
			int x = tmp.x;
			int y = tmp.y;
			int[] dr = { 1, -1, 0, 0 };
			int[] dc = { 0, 0, 1, -1 };
			for (int i = 0; i < 4; i++) {
				if (x + dr[i] >= 1 && x + dr[i] <= N && y + dc[i] >= 1 && y + dc[i] <= M) { // 배열에 넣어도 arrayoutofbound가 안나게 범위설정
					if (map[x + dr[i]][y + dc[i]] == 1 && !visited[x + dr[i]][y + dc[i]]) {
						node[x + dr[i]][y + dc[i]] = new Node(x + dr[i], y + dc[i], tmp.cnt + 1);
						if ((x + dr[i]) == N && (y + dc[i]) == M) {
							break end;//node[N][M]에 cnt를 넣었으면 더 이상의 탐색은 불필요하므로 종료.
						}
						myQueue.add(node[x + dr[i]][y + dc[i]]);
						visited[x + dr[i]][y + dc[i]] = true;
					}
				}
			}
		}
		return node[N][M].cnt;
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