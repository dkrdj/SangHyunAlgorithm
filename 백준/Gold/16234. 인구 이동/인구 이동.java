import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static int[][] arr;
	static int N, L, R, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		Queue<Node> que = new LinkedList<>();
		int[][] visited = new int[N][N];
		int cnt = 1;
		boolean done = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boolean cntUp = false;
				if (visited[i][j] == 0) {
					que.offer(new Node(i, j));
					while (!que.isEmpty()) {
						Node curNode = que.poll();
						for (int k = 0; k < 4; k++) {
							int nr = curNode.r + dr[k];
							int nc = curNode.c + dc[k];
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								if (visited[nr][nc] == 0 && Math.abs(arr[nr][nc] - arr[curNode.r][curNode.c]) >= L
										&& Math.abs(arr[nr][nc] - arr[curNode.r][curNode.c]) <= R) {
									cntUp = true;
									done = false;
									visited[curNode.r][curNode.c] = cnt;
									visited[nr][nc] = cnt;
									que.offer(new Node(nr, nc));
								}
							}
						}
					}
				}
				if (cntUp) {
					cnt++;
					cntUp = false;
				}
			}
		}
		if (done)
			return;

		calc(visited, cnt);

	}

	private static void calc(int[][] visited, int cnt) {
		int[] cntArr = new int[cnt];
		int[] sum = new int[cnt];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] != 0) {
					cntArr[visited[i][j]]++;
					sum[visited[i][j]] += arr[i][j];
				}
			}
		}
		for (int i = 1; i < cnt; i++) {
			sum[i] /= cntArr[i];
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] != 0) {
					arr[i][j] = sum[visited[i][j]];
				}
			}
		}
		ans++;
		bfs();
	}

}

class Node {
	int r;
	int c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}

}
